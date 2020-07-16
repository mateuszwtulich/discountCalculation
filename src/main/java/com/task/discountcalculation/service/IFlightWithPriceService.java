package com.task.discountcalculation.service;

import com.task.discountcalculation.dto.FlightWithPriceDto;
import com.task.discountcalculation.entity.FlightWithPrice;

import java.util.List;
import java.util.Optional;

public interface IFlightWithPriceService {
    Optional<FlightWithPrice> createFlightWithPrice(FlightWithPriceDto flightWithPriceDto);

    Optional<FlightWithPrice> getFlightWithPriceById(Long id);

    Optional<List<FlightWithPrice>> getAllFlightsWithPrices();

    void deleteFlightWithPrice(Long id);
}
