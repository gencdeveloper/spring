package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository <Department,String> {

    //Display all departments in the furniture department

    List<Department>findByDepartment(String Department);

    //Display all Departments in the Health Division
    List<Department> findByDivisionEquals(String division);

    //Display to 3 deprtments with division nme includes 'Hea', without duplicates
    List<Department>findTop3ByDivisionContains(String division);

    @Query("select d from Department d where d.division in ?1")
    List<Department> getDepartmentDivision(List<String>division);
}
