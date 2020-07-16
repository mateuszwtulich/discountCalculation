package com.task.discountcalculation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.task.discountcalculation.entity.criterion.DayOfWeekCriterion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "DAYS_OF_WEEK")
public class DayOfWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(targetEntity = DayOfWeekCriterion.class, mappedBy = "dayOfWeek", fetch = FetchType.LAZY)
    private List<DayOfWeekCriterion> dayOfWeekCriterionList;

    public DayOfWeek() {
    }

    public DayOfWeek(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
