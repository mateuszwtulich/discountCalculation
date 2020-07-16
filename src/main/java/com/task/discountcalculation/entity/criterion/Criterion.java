package com.task.discountcalculation.entity.criterion;

import com.task.discountcalculation.entity.FlightWithPrice;
import com.task.discountcalculation.entity.Tenant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "CRITERIA")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Criterion implements ICriterion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Override
    public boolean isMeetingCriterion(FlightWithPrice flightWithPrice, Tenant tenant) {
        return false;
    }
}
