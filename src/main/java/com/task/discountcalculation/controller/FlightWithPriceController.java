package com.task.discountcalculation.controller;

import com.task.discountcalculation.dto.FlightWithPriceDto;
import com.task.discountcalculation.entity.Flight;
import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.service.FlightWithPriceService;
import com.task.discountcalculation.service.IFlightWithPriceService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FlightWithPriceController {
    private IFlightWithPriceService flightWithPriceService;

    @Autowired
    public FlightWithPriceController(FlightWithPriceService flightWithPriceService) {
        this.flightWithPriceService = flightWithPriceService;
    }

    @ApiOperation(value = "Get list of all flights with prices.",
            tags = {"flightWithPrice", "controller"},
            response = FlightWithPrice.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 204, message = "No content found"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @GetMapping(value = "/flightsWithPrices",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightWithPrice> getAllFlightsWithPrice() {
        return flightWithPriceService.getAllFlightsWithPrices()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Get flight with price by id.",
            tags = {"flightWithPrice", "controller"},
            response = FlightWithPrice.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @GetMapping(value = "/flightWithPrice/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public FlightWithPrice getFlightWithPriceById(@PathVariable(value = "id") Long id) {
        try{
            return flightWithPriceService.getFlightWithPriceById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Creates flight with price",
            tags = {"flightWithPrice", "controller"},
            response = Flight.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PostMapping(value = "/flightWithPrice",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public FlightWithPrice createFlightWithPrice(@Valid @RequestBody FlightWithPriceDto flightWithPriceDto) {
        return flightWithPriceService.createFlightWithPrice(flightWithPriceDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @ApiOperation(value = "Deletes flight with price",
            tags = {"flightWithPrice", "controller"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @DeleteMapping(value = "/flightWithPrice/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteFlightWithPrice(@PathVariable(value = "id") Long id) {
        flightWithPriceService.deleteFlightWithPrice(id);
    }

}
