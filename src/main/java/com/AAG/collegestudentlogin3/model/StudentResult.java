package com.AAG.collegestudentlogin3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // so that all the data getter and setter will be available
@AllArgsConstructor
@NoArgsConstructor
public class StudentResult {
    private Long id;
    private String firstname;
    private String lastname;
    private String course;
    private String result;
    private String grade;
    private String email;
}
