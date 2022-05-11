package com.hightarun.backend.controller;

import com.hightarun.backend.dto.EmployeeRequest;
import com.hightarun.backend.model.Employee;
import com.hightarun.backend.repository.EmployeeRepository;
import com.hightarun.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/signup")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeRequest employeeRequest){
        return new ResponseEntity<>(service.saveEmployee(employeeRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id){
        return ResponseEntity.ok(service.getUser(id));
    }
}
