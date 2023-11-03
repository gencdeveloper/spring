package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "students")// change to table name with @Table anotations.
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //primary key

    @Column(name="studentFirstName")// change to column name with @Column annotations.
    private String firstName;

    @Column(name="studentLastName")
    private String lastName;
    private String email;

    @Transient //this column will not display under the Student table
    private String city;

    @Column(columnDefinition = "DATE") //for column definition
    private LocalDate birthdate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
