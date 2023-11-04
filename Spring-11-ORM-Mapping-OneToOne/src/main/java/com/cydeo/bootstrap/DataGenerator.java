package com.cydeo.bootstrap;


import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import com.cydeo.entity.Region;
import com.cydeo.enums.Gender;
import com.cydeo.repository.DepartmentsRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {


    EmployeeRepository employeeRepository;
    RegionRepository regionRepository;


    public DataGenerator(EmployeeRepository employeeRepository, RegionRepository regionRepository) {
        this.employeeRepository = employeeRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args)throws Exception{

        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();

        Employee employee1 = new Employee( 50000, "John", "Doe", "john.doe@example.com", LocalDate.of(2023, 11, 4), Gender.M);
        Employee employee2 = new Employee( 60000, "Jane", "Smith", "jane.smith@example.com", LocalDate.of(2023, 11, 5), Gender.F);
        Employee employee3 = new Employee( 55000, "Michael", "Johnson", "michael.johnson@example.com", LocalDate.of(2023, 11, 6), Gender.M);
        Employee employee4 = new Employee( 70000, "Emily", "Wilson", "emily.wilson@example.com", LocalDate.of(2023, 11, 7), Gender.F);
        Employee employee5 = new Employee( 75000, "David", "Brown", "david.brown@example.com", LocalDate.of(2023, 11, 8), Gender.M);

        Department department1 = new Department("HR", "Recruitment");
        Department department2 = new Department("Finance", "Accounting");
        Department department3 = new Department("IT", "Development");
        Department department4 = new Department("Sales", "Marketing");
        Department department5 = new Department("Operations", "Logistics");

        Region region1 = new Region("North", "USA");
        Region region2 = new Region("West", "USA");
        Region region3 = new Region("Central", "Canada");
        Region region4 = new Region("East", "Canada");
        Region region5 = new Region("South", "Australia");

        employee1.setDepartment(department5);
        employee2.setDepartment(department4);
        employee3.setDepartment(department1);
        employee4.setDepartment(department3);
        employee5.setDepartment(department2);

        employee1.setRegion(region1);
        employee2.setRegion(region2);
        employee3.setRegion(region3);
        employee4.setRegion(region4);
        employee5.setRegion(region5);

        employeeList.addAll(Arrays.asList(employee1,employee2,employee3,employee4,employee5));
        departmentList.addAll(Arrays.asList(department1,department2,department3,department4,department5));

        employeeRepository.saveAll(employeeList);


    }
}
