package com.task.discountcalculation.entity.criterion;

import com.sun.istack.NotNull;
import com.task.discountcalculation.entity.DayOfWeek;
import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.entity.Tenant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "DAY_OF_WEEK_CRITERIA")
public class DayOfWeekCriterion extends Criterion {

    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "DAY_OF_WEEK_ID", referencedColumnName = "id")
    private DayOfWeek dayOfWeek;

    @Override
    public boolean isMeetingCriterion(FlightWithPrice flightWithPrice, Tenant tenant) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(flightWithPrice.getDate());
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == this.dayOfWeek.getId();
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Happy " + dayOfWeek.getName() + "!";
    }
}
