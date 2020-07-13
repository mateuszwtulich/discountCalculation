package com.task.discountcalculation.dto;


public class BookingDto {
    private Double finalPrice;
    private String discountCriteria;

    public BookingDto(Double finalPrice, String discountCriteria) {
        this.finalPrice = finalPrice;
        this.discountCriteria = discountCriteria;
    }
}
