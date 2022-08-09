package com.armaan.springjpademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
            cascade = CascadeType.ALL // We need to have a Course saved before manipulating or creating a CourseMaterial, that's why use CASCADE
    )
    @JoinColumn( // To define for which particular column these two table can be joined
            name = "course_Id", // Column name that will be created in database
            referencedColumnName = "courseId" // Variable declared in Course class
    )
    private Course course; // A course material can not exist without course, so we define course here
}
