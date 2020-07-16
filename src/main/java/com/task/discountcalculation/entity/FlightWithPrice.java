package com.task.discountcalculation.entity;

import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "FLIGHTS_WITH_PRICE")
public class FlightWithPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "BASE_PRICE", nullable = false)
    private Double flightPrice;

    @NotNull
    @Column(name = "Date", nullable = false)
    private Date date;

    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "FLIGHT_ID", referencedColumnName = "id")
    private Flight flight;

    public FlightWithPrice() {
    }

    public FlightWithPrice(Long id, Double flightPrice, Date date, Flight flight) {
        this.id = id;
        this.flightPrice = flightPrice;
        this.date = date;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(Double flightPrice) {
        this.flightPrice = flightPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightWithPrice)) return false;
        FlightWithPrice that = (FlightWithPrice) o;
        return id.equals(that.id) &&
                flightPrice.equals(that.flightPrice) &&
                date.equals(that.date) &&
                flight.equals(that.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightPrice, date, flight);
    }
}
