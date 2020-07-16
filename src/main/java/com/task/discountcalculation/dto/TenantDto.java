package com.task.discountcalculation.dto;

import com.sun.istack.NotNull;

import java.util.Date;

public class TenantDto {
    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private Date dateOfBirth;

    @NotNull
    private String group;

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
}
