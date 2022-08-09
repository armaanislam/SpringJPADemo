package com.armaan.springjpademo.repository;

import com.armaan.springjpademo.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    
    @Test
    public void printCourses() { // Uni direction: Will only print Course properties; Bi direction: Will print Course properties and also the CourseMaterial properties that are associated with that specific course object
        List<Course> courseList = courseRepository.findAll();

        System.out.println("courseList = " + courseList);
    }
}