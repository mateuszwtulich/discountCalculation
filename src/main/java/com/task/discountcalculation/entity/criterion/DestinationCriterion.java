package com.task.discountcalculation.entity.criterion;

import com.sun.istack.NotNull;
import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.entity.Tenant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DESTINATION_CRITERIA")
public class DestinationCriterion extends Criterion{

    @NotNull
    @Column(name = "DESTINATION", nullable = false)
    private String destination;

    @Override
    public boolean isMeetingCriterion(FlightWithPrice flightWithPrice, Tenant tenant) {
        return destination.equals(flightWithPrice.getFlight().getDestination());
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Happy flight to " + destination + "!";
    }
}
