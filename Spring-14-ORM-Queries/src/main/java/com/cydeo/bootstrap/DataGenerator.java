package com.cydeo.bootstrap;
import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("---------------REGION START---------------");

        System.out.println("findByCountry : " +  regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry : " +  regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining : " +  regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByCountry : " +  regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println("findTopByCountry : " +  regionRepository.findTopByCountry("Canada"));

        System.out.println("---------------REGION END---------------");


    }
}

