package com.task.discountcalculation.service;

import com.task.discountcalculation.dto.BookingDto;
import com.task.discountcalculation.entity.Booking;
import com.task.discountcalculation.entity.Discount;
import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.entity.Tenant;
import com.task.discountcalculation.entity.criterion.Criterion;
import com.task.discountcalculation.repository.BookingRepository;
import com.task.discountcalculation.repository.FlightWithPriceRepository;
import com.task.discountcalculation.repository.TenantRepository;
import com.task.discountcalculation.utils.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class BookingService implements IBookingService{
    private TenantRepository tenantRepository;
    private FlightWithPriceRepository flightWithPriceRepository;
    private CriterionService criterionService;
    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(TenantRepository tenantRepository, FlightWithPriceRepository flightWithPriceRepository,
                          CriterionService criterionService, BookingRepository bookingRepository) {
        this.tenantRepository = tenantRepository;
        this.flightWithPriceRepository = flightWithPriceRepository;
        this.criterionService = criterionService;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Optional<BookingDto> buyFlight(Long flightId, Long tenantId) {
        Tenant tenant = tenantRepository.findById(tenantId).orElseThrow(ResourceNotFoundException::new);
        FlightWithPrice flightWithPrice = flightWithPriceRepository.findById(flightId).orElseThrow(ResourceNotFoundException::new);
        Discount discount = resolveDiscount(tenant, flightWithPrice);

        Booking booking = new Booking.BookingBuilder().tenant(tenant).flightWithPrice(flightWithPrice).discount(discount).build();
        bookingRepository.save(booking);
        return Optional.of(toBookingDto(bookingRepository.save(booking)));
    }

    public Discount resolveDiscount(Tenant tenant, FlightWithPrice flightWithPrice) {
        List<Criterion> criterionList = criterionService.getAllCriteria();
        criterionList = criterionList.stream().
                filter(criterion -> criterion.isMeetingCriterion(flightWithPrice, tenant)).collect(Collectors.toList());

        Discount discount;
        if(tenant.getGroup().equals(Group.A)){
            discount = discountWithSavedCriteria(criterionList, flightWithPrice);
        } else if(tenant.getGroup().equals(Group.B)){
            discount = discountWithoutCriteria(criterionList, flightWithPrice);
        } else {
            throw new ResourceNotFoundException("Group not found");
        }
        return discount;
    }

    public Discount discountWithSavedCriteria(List<Criterion> criterionList, FlightWithPrice flightWithPrice){
        Discount discount = new Discount();
        while((flightWithPrice.getFlightPrice() - discount.getValue()) > 24 && (!criterionList.isEmpty())){
            discount.getCriterionList().add(criterionList.get(0));
            criterionList.remove(0);
            discount.setValue(discount.getValue() + 5);
        }
        return discount;
    }

    public Discount discountWithoutCriteria(List<Criterion> criterionList, FlightWithPrice flightWithPrice){
        Discount discount = new Discount();
        while((flightWithPrice.getFlightPrice() - discount.getValue()) > 24 && (!criterionList.isEmpty())){
            criterionList.remove(0);
            discount.setValue(discount.getValue() + 5);
        }
        return discount;
    }

    public BookingDto toBookingDto(Booking booking){
        Double finalPrice = booking.getFlightWithPrice().getFlightPrice() - booking.getDiscount().getValue();
        StringBuilder criteria = new StringBuilder();
        if(!booking.getDiscount().getCriterionList().isEmpty()){
            booking.getDiscount().getCriterionList().stream().forEach(c -> criteria.append(c + "\n"));
        }
        return new BookingDto(finalPrice, criteria.toString());
    }
}
