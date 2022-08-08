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
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint( // Unique constraints of a table should me defined in the Table annotation
                name = "emailid_unique",
                columnNames = "email_address" // Making a unique email id column with the reference of email_address column
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;

    private String firstName;

    private String lastName;

    @Column(name = "email_address", // Setting the column name to email_address
            nullable = false // Email can not be null
    )
    private String emailId;

    @Embedded
    private Guardian guardian;

}
