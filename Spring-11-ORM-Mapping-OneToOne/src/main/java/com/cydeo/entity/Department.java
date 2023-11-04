package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Data
public class Department extends BaseEntity {

    private String department;
    private String division;               //if you want to reach out to Employee object field from Department object
                                          // then you can create by Directional way

    @OneToOne(mappedBy = "department")//has to match exactly the employees class Department object
                                     // without new populated column
                                    //with mappedBy = "exactly match whatever put EmployeeTable"
    private Employee employee;
    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
