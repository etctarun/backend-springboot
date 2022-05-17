package com.hightarun.backend.controller;

import com.hightarun.backend.dto.StudentRequest;
import com.hightarun.backend.exception.UserNotFoundException;
import com.hightarun.backend.model.Student;
import com.hightarun.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/signup")
    public ResponseEntity<Student> saveStudent(@RequestBody @Valid StudentRequest studentRequest) {
        return new ResponseEntity<>(service.saveUser(studentRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Student>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getEmployee(@PathVariable long id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }
}
