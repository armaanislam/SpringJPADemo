package com.armaan.springjpademo.repository;

import com.armaan.springjpademo.entity.Course;
import com.armaan.springjpademo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial() {

        Course course = Course.builder()
                .title("Goland")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google2.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

        System.out.println("courseMaterials = " + courseMaterials); // We only got the CourseMaterial properties due to making fetch type LAZY(N.B: While doing this, make sure to exclude toString for that particular Class)
    }
}