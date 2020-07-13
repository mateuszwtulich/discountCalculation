package com.task.discountcalculation.entity.criterion;

import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.entity.Tenant;

public class DestinationCriterion implements Criterion{

    private String destination;

    @Override
    public boolean isMeetingCriterion(FlightWithPrice flightWithPrice, Tenant tenant) {
        return destination.equals(flightWithPrice.getFlight().getDestination());
    }
}
