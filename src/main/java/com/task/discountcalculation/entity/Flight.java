package com.task.discountcalculation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Time;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "FLIGHTS")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "ORIGIN", nullable = false)
    private String origin;

    @NotNull
    @Column(name = "DESTINATION", nullable = false)
    private String destination;

    @NotNull
    @Column(name = "TIME", nullable = false)
    private Time time;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "FLIGHT_DAYS_OF_WEEK",
            inverseJoinColumns = {@JoinColumn(
                    name = "DAYS_OF_WEEK_ID", nullable = false, updatable = false
            )},
            joinColumns = {@JoinColumn(
                    name = "FLIGHT_ID", nullable = false, updatable = false
            )}
    )    private List<DayOfWeek> days;

    @JsonIgnore
    @OneToMany(targetEntity = FlightWithPrice.class, mappedBy = "flight", fetch = FetchType.LAZY)
    private List<FlightWithPrice> flightWithPriceList;

    public Flight() {
    }

    public Flight(Long id, String origin, String destination, Time time, List<DayOfWeek> days) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.time = time;
        this.days = days;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(List<DayOfWeek> days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return id.equals(flight.id) &&
                origin.equals(flight.origin) &&
                destination.equals(flight.destination) &&
                time.equals(flight.time) &&
                days.equals(flight.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origin, destination, time, days);
    }
}
