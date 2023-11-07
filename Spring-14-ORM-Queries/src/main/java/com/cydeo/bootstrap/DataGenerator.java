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

        System.out.println("---------------DEPARTMENT START---------------");

        System.out.println("findByDepartment:" + departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDepartment:" + departmentRepository.findByDivisionEquals("Health"));
        System.out.println("findTop3ByDivisionContains" + departmentRepository.findTop3ByDivisionContains("Health"));



        System.out.println("---------------DEPARTMENT END---------------");

        System.out.println("---------------EMPLOYEE START---------------");


        System.out.println( employeeRepository.findByEmail("lcasarolib@plala.or.jp"));
        System.out.println(employeeRepository.findByFirstNameIsNot("Leonora"));
        System.out.println(employeeRepository.findByLastNameStartsWith("E"));

        System.out.println("---------------EMPLOYEE with JPQL---------------");

        System.out.println("EmployeeDetails: "  + employeeRepository.getEmployeeDetail());
        System.out.println("Get Employee Salary" + employeeRepository.getEmployeeSalary());
        System.out.println("Detils" + employeeRepository.getEmployeeDetail());

        System.out.println("---------------EMPLOYEE END---------------");

        System.out.println("---------------COURSE START for drive query---------------");

        courseRepository.findByCategory("Spring").forEach(System.out::println);
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
        System.out.println(courseRepository.existsByName("Sts"));
        System.out.println(courseRepository.countByCategory("Spring"));
        System.out.println(courseRepository.findByNameStartsWith("Sp"));
        courseRepository.streamByCategory("Spring").forEach(System.out::println);


        System.out.println("---------------COURSE END---------------");

    }
}

