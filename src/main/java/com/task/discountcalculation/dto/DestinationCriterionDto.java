package com.task.discountcalculation.dto;

import com.sun.istack.NotNull;

public class DestinationCriterionDto {
    @NotNull
    private String destination;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
