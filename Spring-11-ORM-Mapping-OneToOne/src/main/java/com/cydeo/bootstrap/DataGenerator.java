package com.cydeo.bootstrap;


import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import com.cydeo.enums.Gender;
import com.cydeo.repository.DepartmentsRepository;
import com.cydeo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {


    EmployeeRepository employeeRepository;
    DepartmentsRepository departmentsRepository;

    public DataGenerator(EmployeeRepository employeeRepository, DepartmentsRepository departmentsRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentsRepository = departmentsRepository;
    }


    @Override
    public void run(String... args)throws Exception{



    }
}
