package com.task.discountcalculation.controller;

import com.task.discountcalculation.dto.FlightDto;
import com.task.discountcalculation.entity.Flight;
import com.task.discountcalculation.service.FlightService;
import com.task.discountcalculation.service.IFlightService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FlightController {
    private IFlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @ApiOperation(value = "Get list of all flights.",
            tags = {"flight", "controller"},
            response = Flight.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 204, message = "No content found"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @GetMapping(value = "/flights",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Get flight by id.",
            tags = {"flight", "controller"},
            response = Flight.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @GetMapping(value = "/flight/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Flight getFlightById(@PathVariable(value = "id") Long id) {
        try{
            return flightService.getFlightById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Creates flight",
            tags = {"flight", "controller"},
            response = Flight.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PostMapping(value = "/flight",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Flight createFlight(@Valid @RequestBody FlightDto flightDto) {
        return flightService.createFlight(flightDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @ApiOperation(value = "Updates flight",
            tags = {"flight", "controller"},
            response = Flight.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PutMapping(value = "/flight/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Flight updateFlight(@Valid @RequestBody FlightDto flightDto, @PathVariable(value = "id") Long id) {
        return flightService.updateFlight(id, flightDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @ApiOperation(value = "Deletes flight",
            tags = {"flight", "controller"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @DeleteMapping(value = "/flight/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteFlight(@PathVariable(value = "id") Long id) {
        flightService.deleteFlight(id);
    }

}

