package com.armaan.springjpademo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course") // As we have declared FetchType Lazy for Course, it will show an error printing ToString for Course; so we excluded it
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;

    private String url;

    @OneToOne(
            cascade = CascadeType.ALL, // We need to have a Course saved before manipulating or creating a CourseMaterial, that's why use CASCADE
            fetch = FetchType.LAZY // EAGER = Brings Course while working with CourseMaterial; Lazy = Does not bring Course while working with CourseMaterial
    )
    @JoinColumn( // To define for which particular column these two table can be joined
            name = "course_Id", // Column name that will be created in database
            referencedColumnName = "courseId" // Variable declared in Course class
    )
    private Course course; // A course material can not exist without course, so we define course here
}
