package com.AAG.collegestudentlogin3.repository;

import com.AAG.collegestudentlogin3.entity.StudentResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentResultRepository extends JpaRepository<StudentResultEntity, Long> {

}
