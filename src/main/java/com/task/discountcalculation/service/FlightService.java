package com.task.discountcalculation.service;

import com.task.discountcalculation.dto.FlightDto;
import com.task.discountcalculation.entity.Flight;
import com.task.discountcalculation.repository.DayOfWeekRepository;
import com.task.discountcalculation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlightService implements  IFlightService{
    private FlightRepository flightRepository;
    private DayOfWeekRepository dayOfWeekRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, DayOfWeekRepository dayOfWeekRepository) {
        this.flightRepository = flightRepository;
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    @Override
    public Optional<Flight> createFlight(FlightDto flightDto) {
        return Optional.of(flightRepository.save(toFlight(flightDto)));
    }

    @Override
    public Optional<Flight> getFlightById(Long id) {
        return Optional.of(flightRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public Optional<List<Flight>> getAllFlights() {
        return Optional.of(flightRepository.findAll());
    }

    @Override
    public Optional<Flight> updateFlight(Long id, FlightDto flightDto) {
        return Optional.of(flightRepository.findById(id).map(flight -> {
            flight.setTime(flightDto.getTime());
            flight.setDestination(flightDto.getDestination());
            flight.setOrigin(flightDto.getOrigin());
            flight.setDays(flightDto.getDayOfWeekIdList().stream()
                    .map(idF -> dayOfWeekRepository.findById(idF).orElseThrow(IllegalArgumentException::new))
                    .collect(Collectors.toList()));
            return flight;
        })).orElseThrow(IllegalArgumentException::new);    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    private Flight toFlight(FlightDto flightDto){
        if(flightDto == null){
            return null;
        }

        Flight flight = new Flight();
        flight.setTime(flightDto.getTime());
        flight.setDestination(flightDto.getDestination());
        flight.setOrigin(flightDto.getOrigin());
        flight.setDays(flightDto.getDayOfWeekIdList().stream()
                .map(id -> dayOfWeekRepository.findById(id).orElseThrow(IllegalArgumentException::new))
                .collect(Collectors.toList()));
        return flight;
    }
}
