package com.task.discountcalculation.dto;

import com.sun.istack.NotNull;

import java.util.Date;

public class FlightWithPriceDto {

    @NotNull
    private Double flightPrice;
    @NotNull
    private Date date;
    @NotNull
    private Long flightId;

    public Double getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(Double flightPrice) {
        this.flightPrice = flightPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
