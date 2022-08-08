package com.armaan.springjpademo.repository;

import com.armaan.springjpademo.entity.Guardian;
import com.armaan.springjpademo.entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // Standard Test Annotation
// @DataJpaTest // This test annotation flashes every data after testing is finished; Use any one of them
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository studentRepository;

    @Test
    @Disabled
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("sam@gmail.com")
                .firstName("Sam")
                .lastName("Nicole")
//                .guardianName("David")
//                .guardianEmail("david@gmail.com")
//                .guardianMobile("01738493847")
                .build();

        studentRepository.save(student); // 3 queries executed; select from student_sequence; update in student_sequence; insert in schooldb.student table
    }

    @Test
    @Disabled
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("John")
                .email("john@gmail.com")
                .mobile("01738493847")
                .build();

        Student student = Student.builder()
                .emailId("Lincoln@gmail.com")
                .firstName("Lincoln")
                .lastName("Johnson")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    @Disabled
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("Mi");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("David");

        System.out.println("students = " + students);
    }


    @Test
    public void printStudentBasedOnLastNameNotNull() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();

        System.out.println("studentList = " + studentList);
    }


}