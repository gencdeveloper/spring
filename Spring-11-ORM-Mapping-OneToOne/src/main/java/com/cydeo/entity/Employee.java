package com.cydeo.entity;

import com.cydeo.enums.Gender;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity { //table name



    private int salary;
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    //@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="department_id") //change name of foreign column
    private Department department; //has a relationsShip

    @OneToOne(cascade = CascadeType.ALL)
    //@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="region_id") //change name of foreign column
    private Region region; //has a relationsShip
    public Employee(int salary, String firstName, String lastName, String email, LocalDate hireDate,Gender gender) {

        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
    }
}
