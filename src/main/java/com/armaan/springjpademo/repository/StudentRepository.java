package com.armaan.springjpademo.repository;

import com.armaan.springjpademo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name); // If name = "Armaan"; "Ar" will also fetch data

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT s FROM Student s WHERE s.emailId = ?1") // JPQL Query: It is based on the classes we created, not on the tables in our SQL
    Student getStudentByEmailAddress(String emailId);

    @Query("SELECT s.firstName FROM Student  s WHERE s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

}
