package com.task.discountcalculation.dto;


import com.sun.istack.NotNull;

import java.sql.Time;
import java.util.List;

public class FlightDto {
    @NotNull
    private String origin;

    @NotNull
    private String destination;

    @NotNull
    private Time time;

    @NotNull
    private List<Long> dayOfWeekIdList;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<Long> getDayOfWeekIdList() {
        return dayOfWeekIdList;
    }

    public void setDayOfWeekIdList(List<Long> dayOfWeekIdList) {
        this.dayOfWeekIdList = dayOfWeekIdList;
    }
}
