package com.task.discountcalculation.entity.criterion;

import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.entity.Tenant;

public interface Criterion {

    public boolean isMeetingCriterion(FlightWithPrice flightWithPrice, Tenant tenant);
}
