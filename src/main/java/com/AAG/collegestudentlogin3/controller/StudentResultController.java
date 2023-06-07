package com.AAG.collegestudentlogin3.controller;

import com.AAG.collegestudentlogin3.model.StudentResult;
import com.AAG.collegestudentlogin3.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/v3")
public class StudentResultController {

    private final StudentService studentService;

    public StudentResultController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students") // whenever you will hit "/api/v3/students" the next particular method will be called
    public StudentResult createStudentResult(@RequestBody StudentResult studentResult){
        return studentService.createStudentResult(studentResult);
    }

    @GetMapping("/students")
    public List<StudentResult> getAllStudentResult(){
        return studentService.getAllStudentResult();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteStudentResult(@PathVariable Long id) {
        boolean deleted = false;
        deleted = studentService.deleteStudentResult(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResult> getStudentResultById(@PathVariable Long id){
        StudentResult studentResult = null;
        studentResult = studentService.getStudentResultById(id);
        return ResponseEntity.ok(studentResult);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResult> updateStudentResult(@PathVariable Long id,
                                                              @RequestBody StudentResult studentResult){
        studentResult = studentService.updateStudentResult(id, studentResult);
        return ResponseEntity.ok(studentResult);
    }
}
