package com.hightarun.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // by default jpa takes field name as column name
    @Column(name = "name")
    private String name;
    @Column(name = "roll_no")
    private long rollNo;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "department")
    private String department;
}
