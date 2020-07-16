package com.task.discountcalculation.entity;

import com.sun.istack.NotNull;
import com.task.discountcalculation.entity.criterion.Criterion;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DISCOUNTS")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "VALUE", nullable = false)
    private int value = 0;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "DISCOUNT_CRITERION",
            inverseJoinColumns = {@JoinColumn(
                    name = "CRITERION_ID", nullable = false, updatable = false
            )},
            joinColumns = {@JoinColumn(
                    name = "DISCOUNT_ID", nullable = false, updatable = false
            )}
    )
    private List<Criterion> criterionList = new ArrayList<>();

    public Discount() {
    }

    public Discount(final DiscountBuilder builder) {
        this.id = builder.id;
        this.value = builder.value;
        this.criterionList = builder.criterionList;
    }

    public static class DiscountBuilder {
        private Long id;
        private int value;
        private List<Criterion> criterionList;


        public DiscountBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DiscountBuilder value(int value) {
            this.value = value;
            return this;
        }

        public DiscountBuilder criterionList(List<Criterion> criterionList) {
            this.criterionList = criterionList;
            return this;
        }

        public Discount build() {
            return new Discount(this);
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int  value) {
        this.value = value;
    }

    public List<Criterion> getCriterionList() {
        return criterionList;
    }

    public void setCriterionList(List<Criterion> criterionList) {
        this.criterionList = criterionList;
    }
}
