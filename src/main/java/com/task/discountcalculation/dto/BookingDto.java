package com.task.discountcalculation.dto;


import com.sun.istack.NotNull;

import java.util.List;

public class BookingDto {
    @NotNull
    private Double finalPrice;
    @NotNull
    private List<String> criterionList;

    public BookingDto(){
    }

    public BookingDto(Double finalPrice, List<String> criterionList) {
        this.finalPrice = finalPrice;
        this.criterionList = criterionList;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public List<String> getCriterionList() {
        return criterionList;
    }

    public void setCriterionList(List<String> criterionList) {
        this.criterionList = criterionList;
    }
}
