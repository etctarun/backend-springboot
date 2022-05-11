package com.hightarun.backend.repository;

import com.hightarun.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // all CRUD database methods
    Employee findById(long id);
}
