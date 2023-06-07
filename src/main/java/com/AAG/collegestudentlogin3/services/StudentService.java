package com.AAG.collegestudentlogin3.services;

import com.AAG.collegestudentlogin3.model.StudentResult;

import java.util.List;

public interface StudentService{
    StudentResult createStudentResult(StudentResult studentResult);

    List<StudentResult> getAllStudentResult();

    boolean deleteStudentResult(Long id);

    StudentResult getStudentResultById(Long id);

    StudentResult updateStudentResult(Long id, StudentResult studentResult);
}
