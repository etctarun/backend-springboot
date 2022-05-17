package com.hightarun.backend.service;

import com.hightarun.backend.dto.StudentRequest;
import com.hightarun.backend.exception.UserNotFoundException;
import com.hightarun.backend.model.Student;
import com.hightarun.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveUser(StudentRequest studentRequest) {
        Student student = Student.build(0, studentRequest.getName(), studentRequest.getRollNo(), studentRequest.getEmailId(), studentRequest.getDepartment());
        return studentRepository.save(student);
    }

    public List<Student> getAllUsers() {
        return studentRepository.findAll();
    }

    public Student getUser(long id) throws UserNotFoundException {
        Student emp = studentRepository.findById(id);
        if (emp != null) {
            return emp;
        } else {
            throw new UserNotFoundException("User Not found with id: " + id);
        }
    }
}
