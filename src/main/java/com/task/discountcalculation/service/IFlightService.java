package com.task.discountcalculation.service;

import com.task.discountcalculation.dto.FlightDto;
import com.task.discountcalculation.entity.Flight;

import java.util.List;
import java.util.Optional;

public interface IFlightService {

    Optional<Flight> createFlight(FlightDto flightDto);

    Optional<Flight> getFlightById(Long id);

    Optional<List<Flight>> getAllFlights();

    Optional<Flight> updateFlight(Long id, FlightDto flightDto);

    void deleteFlight(Long id);
}
