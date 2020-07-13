package com.task.discountcalculation.entity.criterion;

import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.entity.Tenant;

public class DayOfBirthCriterion implements Criterion {
    @Override
    public boolean isMeetingCriterion(FlightWithPrice flightWithPrice, Tenant tenant) {
        return flightWithPrice.getTime().toLocalDateTime().toLocalDate().equals(tenant.getDateOfBirth());
    }
}
