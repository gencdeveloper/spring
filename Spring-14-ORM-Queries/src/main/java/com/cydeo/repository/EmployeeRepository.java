package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Displayu all employees with email adress
    List<Employee> findByEmail(String email);


    //Displayu all employees with firstName '' and last name '' also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String LastName,String email);

    //Display all employees that first name is not ''
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where last name starts with ''
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salaries higher than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less than  ''
    List<Employee>findBySalaryLessThanEqual(Integer salary);

    //Display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate,LocalDate endDate);

    //Display all employees where salaries greater and equal to '' in order.
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than ''
    List<Employee>findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

    @Query("select e FROM Employee e where e.email = 'lcasarolib@plala.or.jp'")
    Employee getEmployeeDetail();

    @Query("Select e.salary from Employee e where e.email = 'lcasarolib@plala.or.jp' ")
    Integer getEmployeeSalary();

    @Query("Select e from Employee e where e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("Select e From Employee e where e.email=?1 AND e.salary=?2")
    Optional<Employee>  getEmployeeDetail(String email,int salary);
}
