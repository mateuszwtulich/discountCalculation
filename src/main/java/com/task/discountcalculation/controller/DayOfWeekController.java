package com.task.discountcalculation.controller;

import com.task.discountcalculation.entity.DayOfWeek;
import com.task.discountcalculation.service.DayOfWeekService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DayOfWeekController {
    private DayOfWeekService dayOfWeekService;

    @Autowired
    public DayOfWeekController(DayOfWeekService dayOfWeekService) {
        this.dayOfWeekService = dayOfWeekService;
    }

    @ApiOperation(value = "Get list of all days.",
            tags = {"days", "controller"},
            response = DayOfWeek.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 204, message = "No content found"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @GetMapping(value = "/days",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DayOfWeek> getAllDaysOfWeek() {
        return dayOfWeekService.getAllDaysOfWeek()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
}
