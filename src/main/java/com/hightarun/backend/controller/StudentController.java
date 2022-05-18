package com.hightarun.backend.controller;

import com.hightarun.backend.dto.StudentRequestDTO;
import com.hightarun.backend.exception.InvalidDepartmentException;
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

    // POST - REGISTER STUDENT
    @PostMapping("/signup")
    public ResponseEntity<StudentRequestDTO> saveStudent(@RequestBody @Valid StudentRequestDTO studentRequestDTO) throws InvalidDepartmentException {
        return new ResponseEntity<>(service.saveUser(studentRequestDTO), HttpStatus.CREATED);
    }

    // GET - ALL STUDENT DETAILS
    @GetMapping("/fetchAll")
    public ResponseEntity<List<StudentRequestDTO>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    // GET - STUDENT DETAILS BY ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentRequestDTO> getEmployee(@PathVariable long id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }

    // PUT - UPDATE STUDENT DETAILS
    @PutMapping("/{id}")
    public ResponseEntity<StudentRequestDTO> updateStudent(@PathVariable long id, @RequestBody StudentRequestDTO studentRequestDTO) throws UserNotFoundException, InvalidDepartmentException {
        return new ResponseEntity<>(service.updateUser(id, studentRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id) throws UserNotFoundException {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
