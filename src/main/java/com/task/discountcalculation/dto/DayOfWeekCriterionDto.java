package com.task.discountcalculation.dto;

import com.sun.istack.NotNull;

public class DayOfWeekCriterionDto {
    @NotNull
    private Long dayOfWeekId;

    public Long getDayOfWeekId() {
        return dayOfWeekId;
    }

    public void setDayOfWeekId(Long dayOfWeekId) {
        this.dayOfWeekId = dayOfWeekId;
    }
}
