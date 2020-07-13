package com.task.discountcalculation.entity.criterion;

import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.entity.Tenant;
import com.task.discountcalculation.utils.DayOfWeek;

public class DayOfWeekCriterion implements Criterion {

    private DayOfWeek dayOfWeek;

    @Override
    public boolean isMeetingCriterion(FlightWithPrice flightWithPrice, Tenant tenant) {
        return flightWithPrice.getFlight().getDays().stream().anyMatch(dayOfWeek1 -> dayOfWeek1.equals(dayOfWeek));
    }
}
