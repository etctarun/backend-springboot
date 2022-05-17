package com.hightarun.backend;

import com.hightarun.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Autowired
    private StudentRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
/*		Employee employee = new Employee();
		employee.setFName("Tarun");
		employee.setLName("Bisht");
		employee.setEmailId("tb@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFName("Megha");
		employee1.setLName("Samant");
		employee1.setEmailId("ms@gmail.com");
		employeeRepository.save(employee1);*/
    }
}
