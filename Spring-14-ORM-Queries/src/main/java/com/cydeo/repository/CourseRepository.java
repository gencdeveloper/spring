package com.cydeo.repository;

import com.cydeo.entity.Course;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //find all course by category
    List<Course> findByCategory(String category);

    //FIND ALL courses by categoory and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //check if a course with the provided name exists. return true if course exist, false otherwise
    boolean existsByName(String name);

    //return the count of courses for the provided category
    int countByCategory(String category);

    //find all courses that start with the provided course name
    List<Course>findByNameStartsWith(String name);

    //find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category);
}
