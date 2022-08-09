package com.armaan.springjpademo.repository;

import com.armaan.springjpademo.entity.Course;
import com.armaan.springjpademo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Shaan")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
    
    // Paging
    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3); // Pageable from data domain
        Pageable secondPageWithTwoRecord = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        System.out.println("courses = " + courses);

        Long totalElements= courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        System.out.println("totalElements = " + totalElements);

        Long totalPages = Long.valueOf(courseRepository.findAll(firstPageWithThreeRecords).getTotalPages());
        System.out.println("totalPages = " + totalPages);
    }
    
    // Sorting
    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("Credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("Credit")));
        
        List<Course> courses = courseRepository.findAll(sortByCreditDesc).getContent();
        System.out.println("courses = " + courses);
    }
    
    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courseList = courseRepository.findByTitleContaining("DB", firstPageTenRecords).getContent();

        System.out.println("courseList = " + courseList);
    }
    
}