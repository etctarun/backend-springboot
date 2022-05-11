package com.hightarun.backend.service;

import com.hightarun.backend.dto.EmployeeRequest;
import com.hightarun.backend.model.Employee;
import com.hightarun.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(EmployeeRequest employeeRequest){
        Employee employee = Employee.build(0, employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getEmailId());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllUsers(){
        return employeeRepository.findAll();
    }

    public Employee getUser(long id){
        return employeeRepository.findById(id);
    }
}
