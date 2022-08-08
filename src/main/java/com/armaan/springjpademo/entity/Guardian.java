package com.armaan.springjpademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // This Guardian class is now embedded inside the Student class but without creating a separate table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({ // Mapping the Guardian class variable such as guardian_name, guardian_email, guardian_mobile
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
        )
})
public class Guardian {

    private String name;

    private String email;

    private String mobile;
}
