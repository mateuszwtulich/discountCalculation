package com.task.discountcalculation.entity.criterion;

import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.entity.Tenant;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "DAY_OF_BIRTH_CRITERIA")
public class DayOfBirthCriterion extends Criterion {

    @Override
    public boolean isMeetingCriterion(FlightWithPrice flightWithPrice, Tenant tenant) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(flightWithPrice.getDate());
        cal2.setTime(tenant.getDateOfBirth());
        return cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        return "Happy birthday!";
    }
}
