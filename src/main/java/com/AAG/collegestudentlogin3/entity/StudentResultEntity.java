package com.AAG.collegestudentlogin3.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "students")
public class StudentResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "course_name")
    private String course;

    private String result;
    private String grade;
    private String email;
}
