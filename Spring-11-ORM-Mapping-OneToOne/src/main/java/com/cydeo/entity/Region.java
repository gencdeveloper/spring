package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
@NoArgsConstructor
@Data
public class Region extends BaseEntity{

    private String region;
    private String country;

    @OneToOne(mappedBy = "region")//has to match exactly the employees class Department object
    // without new populated column
    //with mappedBy = "exactly match whatever put EmployeeTable"
    private Employee employee;

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
