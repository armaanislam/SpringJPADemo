package com.armaan.springjpademo.repository;

import com.armaan.springjpademo.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Custom method for sorting
    Page<Course> findByTitleContaining(String title, Pageable pageable); // Getting as a page object
}
