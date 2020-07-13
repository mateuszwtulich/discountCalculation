package com.task.discountcalculation.entity;
import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKINGS")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "TENANT_ID", referencedColumnName = "id")
    private Tenant tenant;

    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "FLIGHT_WITH_PRICE_ID", referencedColumnName = "id")
    private FlightWithPrice flightWithPrice;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "DISCOUNT_ID", nullable = false, referencedColumnName = "id", unique = true)
    private Discount discount;

    public Booking() {
    }

    public Booking(final BookingBuilder builder) {
        this.id = builder.id;
        this.tenant = builder.tenant;
        this.flightWithPrice = builder.flightWithPrice;
        this.discount = builder.discount;
    }

    public static class BookingBuilder {
        private Long id;
        private Tenant tenant;
        private FlightWithPrice flightWithPrice;
        private Discount discount;

        public BookingBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BookingBuilder tenant(Tenant tenant) {
            this.tenant = tenant;
            return this;
        }

        public BookingBuilder flightWithPrice(FlightWithPrice flightWithPrice) {
            this.flightWithPrice = flightWithPrice;
            return this;
        }

        public BookingBuilder discount(Discount discount) {
            this.discount = discount;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public FlightWithPrice getFlightWithPrice() {
        return flightWithPrice;
    }

    public void setFlightWithPrice(FlightWithPrice flightWithPrice) {
        this.flightWithPrice = flightWithPrice;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
