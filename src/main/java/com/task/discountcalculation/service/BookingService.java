package com.task.discountcalculation.service;

import com.task.discountcalculation.dto.BookingDto;
import com.task.discountcalculation.entity.Booking;
import com.task.discountcalculation.entity.Discount;
import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.entity.Tenant;
import com.task.discountcalculation.entity.criterion.Criterion;
import com.task.discountcalculation.repository.BookingRepository;
import com.task.discountcalculation.repository.DiscountRepository;
import com.task.discountcalculation.repository.FlightWithPriceRepository;
import com.task.discountcalculation.repository.TenantRepository;
import com.task.discountcalculation.utils.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private DiscountRepository discountRepository;

    @Autowired
    public BookingService(TenantRepository tenantRepository, FlightWithPriceRepository flightWithPriceRepository,
                          CriterionService criterionService, BookingRepository bookingRepository, DiscountRepository discountRepository) {
        this.tenantRepository = tenantRepository;
        this.flightWithPriceRepository = flightWithPriceRepository;
        this.criterionService = criterionService;
        this.bookingRepository = bookingRepository;
        this.discountRepository = discountRepository;
    }

    @Override
    public Optional<BookingDto> buyFlight(Long flightId, Long tenantId) {
        Tenant tenant = tenantRepository.findById(tenantId).orElseThrow(IllegalArgumentException::new);
        FlightWithPrice flightWithPrice = flightWithPriceRepository.findById(flightId).orElseThrow(IllegalArgumentException::new);
        Discount discount = discountRepository.save(resolveDiscount(tenant, flightWithPrice));

        Booking booking = new Booking.BookingBuilder().tenant(tenant).flightWithPrice(flightWithPrice).discount(discount).build();
        return Optional.of(toBookingDto(bookingRepository.save(booking)));
    }

    public Discount resolveDiscount(Tenant tenant, FlightWithPrice flightWithPrice) {
        List<Criterion> criterionList = criterionService.getAllCriteria();
        criterionList = criterionList.stream().
                filter(criterion -> criterion.isMeetingCriterion(flightWithPrice, tenant)).collect(Collectors.toList());
        Discount discount = new Discount();
        criterionList.stream().forEach(criterion -> {
            if((flightWithPrice.getFlightPrice() - discount.getValue()) > 24){
                discount.setValue(discount.getValue() + 5);
                discount.getCriterionList().add(criterion);
            }
        });

        if(tenant.getGroup().equals(Group.B.name)){
            discount.getCriterionList().clear();
        }
        return discount;
    }

    public BookingDto toBookingDto(Booking booking){
        Double finalPrice = booking.getFlightWithPrice().getFlightPrice() - booking.getDiscount().getValue();
        return new BookingDto(finalPrice, booking.getDiscount().getCriterionList()
                .stream().map(criterion -> criterion.toString()).collect(Collectors.toList()));
    }
}
