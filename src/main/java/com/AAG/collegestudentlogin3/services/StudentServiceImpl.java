package com.AAG.collegestudentlogin3.services;

import com.AAG.collegestudentlogin3.entity.StudentResultEntity;
import com.AAG.collegestudentlogin3.model.StudentResult;
import com.AAG.collegestudentlogin3.repository.StudentResultRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentResultRepository studentResultRepository;

    public StudentServiceImpl(StudentResultRepository studentResultRepository) {
        this.studentResultRepository = studentResultRepository;
    }

    @Override
    public StudentResult createStudentResult(StudentResult studentResult) { //we have to convert to studentResult Entity to save to the database
       //Here it will copy all the studentsResult and pass it to studentResultEntity
        StudentResultEntity studentResultEntity = new StudentResultEntity();

        BeanUtils.copyProperties(studentResult, studentResultEntity);
        //Here we have to call the repository to pass the studentResultEntity
        studentResultRepository.save(studentResultEntity);
        return studentResult;
    }

    @Override
    public List<StudentResult> getAllStudentResult() {
        List<StudentResultEntity> studentResultEntities
                = studentResultRepository.findAll();
        //Next convert the above list of Entity to List of StudentResults by creating an object below
        //And use map method to convert studentResultEntity to StudentResultList to be consumed by UI
        List<StudentResult> studentResults = studentResultEntities
                .stream()
                .map(studResult -> new StudentResult(
                        studResult.getId(),
                        studResult.getFirstname(),
                        studResult.getLastname(),
                        studResult.getCourse(),
                        studResult.getResult(),
                        studResult.getGrade(),
                        studResult.getEmail()))
                .collect(Collectors.toList());
        return studentResults;
    }

    @Override
    public boolean deleteStudentResult(Long id) {
        StudentResultEntity studentResult = studentResultRepository.findById(id).get();
        studentResultRepository.delete(studentResult);
        return true;
    }

    @Override
    public StudentResult getStudentResultById(Long id) {
        StudentResultEntity studentResultEntity
                = studentResultRepository.findById(id).get();
        StudentResult studentResult = new StudentResult();
        BeanUtils.copyProperties(studentResultEntity, studentResult);
        return studentResult;
    }

    @Override
    public StudentResult updateStudentResult(Long id, StudentResult studentResult) {
        StudentResultEntity studentResultEntity
            = studentResultRepository.findById(id).get();
        studentResultEntity.setFirstname(studentResult.getFirstname());
        studentResultEntity.setLastname(studentResult.getLastname());
        studentResultEntity.setCourse(studentResult.getCourse());
        studentResultEntity.setResult(studentResult.getResult());
        studentResultEntity.setGrade(studentResult.getGrade());
        studentResultEntity.setEmail(studentResult.getEmail());

        studentResultRepository.save(studentResultEntity);
        return studentResult;
    }
}
