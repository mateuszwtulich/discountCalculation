package com.task.discountcalculation.controller;

import com.task.discountcalculation.dto.DayOfWeekCriterionDto;
import com.task.discountcalculation.dto.DestinationCriterionDto;
import com.task.discountcalculation.entity.Flight;
import com.task.discountcalculation.entity.criterion.DayOfWeekCriterion;
import com.task.discountcalculation.entity.criterion.DestinationCriterion;
import com.task.discountcalculation.service.ICriterionService;
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
public class CriterionController {
    private ICriterionService criterionService;

    @Autowired
    public CriterionController(ICriterionService criterionService) {
        this.criterionService = criterionService;
    }

    @ApiOperation(value = "Get list of all destination criteria.",
            tags = {"destinationCritera", "controller"},
            response = Flight.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 204, message = "No content found"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })

    @GetMapping(value = "/destinationCriteria",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DestinationCriterion> getAllDestinationCriteria() {
        return criterionService.getAllDestinationCriteria()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Get list of all day of week criteria.",
            tags = {"dayOfWeekCriteria", "controller"},
            response = Flight.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 204, message = "No content found"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @GetMapping(value = "/dayOfWeekCriteria",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DayOfWeekCriterion> getAllDayOfWeekCriteria() {
        return criterionService.getAllDayOfWeekCriteria()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Creates destination criterion",
            tags = {"destinationCriterion", "controller"},
            response = DestinationCriterion.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PostMapping(value = "/destinationCriterion",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DestinationCriterion createDestinationCriterion(@Valid @RequestBody DestinationCriterionDto destinationCriterionDto) {
        return criterionService.createDestinationCriterion(destinationCriterionDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @ApiOperation(value = "Creates day of week criterion",
            tags = {"dayOfWeekCriterion", "controller"},
            response = DayOfWeekCriterion.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PostMapping(value = "/dayOfWeekCriterion",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DayOfWeekCriterion createDayOfWeekCriterion(@Valid @RequestBody DayOfWeekCriterionDto dayOfWeekCriterionDto) {
        return criterionService.createDayOfWeek(dayOfWeekCriterionDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @ApiOperation(value = "Deletes destination criterion",
            tags = {"destinationCriterion", "controller"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @DeleteMapping(value = "/destinationCriterion/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDestinationCriterion(@PathVariable(value = "id") Long id) {
        criterionService.deleteDestinationCriteria(id);
    }

    @ApiOperation(value = "Deletes dayOfWeek criterion",
            tags = {"dayOfWeekCriterion", "controller"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @DeleteMapping(value = "/dayOfWeekCriterion/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDayOfWeekCriterion(@PathVariable(value = "id") Long id) {
        criterionService.deleteDayOfWeekCriteria(id);
    }

}
