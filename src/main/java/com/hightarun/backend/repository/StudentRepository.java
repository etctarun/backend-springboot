package com.hightarun.backend.repository;

import com.hightarun.backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // all CRUD database methods
    public Student findById(long id);
}
