package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Employee { //table name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //column name
    private String name;

}
