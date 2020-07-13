package com.task.discountcalculation.entity;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TENANTS")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @NotNull
    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private Date dateOfBirth;

    @NotNull
    @Column(name = "GROUP", nullable = false)
    private String group;

    public Tenant (){

    }

    public Tenant(Long id, String name, String surname, Date dateOfBirth, String group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.group = group;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tenant)) return false;
        Tenant tenant = (Tenant) o;
        return Objects.equals(id, tenant.id) &&
                Objects.equals(name, tenant.name) &&
                Objects.equals(surname, tenant.surname) &&
                Objects.equals(dateOfBirth, tenant.dateOfBirth) &&
                Objects.equals(group, tenant.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, dateOfBirth, group);
    }
}
