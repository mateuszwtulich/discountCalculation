package com.task.discountcalculation.service;

import com.task.discountcalculation.dto.FlightDto;
import com.task.discountcalculation.dto.FlightWithPriceDto;
import com.task.discountcalculation.entity.Flight;
import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.repository.FlightRepository;
import com.task.discountcalculation.repository.FlightWithPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FlightWithPriceService implements IFlightWithPriceService{
    private FlightWithPriceRepository flightWithPriceRepository;
    private FlightRepository flightRepository;

    @Autowired
    public FlightWithPriceService(FlightWithPriceRepository flightWithPriceRepository, FlightRepository flightRepository) {
        this.flightWithPriceRepository = flightWithPriceRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public Optional<FlightWithPrice> createFlightWithPrice(FlightWithPriceDto flightWithPriceDto) {
        return Optional.of(flightWithPriceRepository.save(toFlightWithPrice(flightWithPriceDto)));
    }

    @Override
    public Optional<FlightWithPrice> getFlightWithPriceById(Long id) {
        return Optional.of(flightWithPriceRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public Optional<List<FlightWithPrice>> getAllFlightsWithPrices() {
        return Optional.of(flightWithPriceRepository.findAll());
    }

    @Override
    public void deleteFlightWithPrice(Long id) {
        flightWithPriceRepository.deleteById(id);
    }

    private FlightWithPrice toFlightWithPrice(FlightWithPriceDto flightWithPriceDto){
        if(flightWithPriceDto == null){
            return null;
        }

        FlightWithPrice flightWithPrice = new FlightWithPrice();
        flightWithPrice.setDate(flightWithPriceDto.getDate());
        flightWithPrice.setFlightPrice(flightWithPriceDto.getFlightPrice());
        flightWithPrice.setFlight(flightRepository.findById(flightWithPriceDto.getFlightId())
                .orElseThrow(IllegalArgumentException::new));

        return flightWithPrice;
    }
}
