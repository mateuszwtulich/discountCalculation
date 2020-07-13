package com.task.discountcalculation.controller;

import com.task.discountcalculation.dto.BookingDto;
import com.task.discountcalculation.entity.Booking;
import com.task.discountcalculation.service.BookingService;
import com.task.discountcalculation.service.IBookingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

public class BookingController {
    private IBookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @ApiOperation(value = "Creates project",
            tags = {"project", "controller"},
            response = Booking.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PostMapping(value = "/booking",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingDto buyFlight(@PathVariable(value = "flightId") Long flightWithProjectId, @PathVariable(value = "tenantId") Long tenantId) {
        return bookingService.buyFlight(flightWithProjectId, tenantId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY));
    }
}
