package com.hightarun.backend.service;

import com.hightarun.backend.dto.StudentRequestDTO;
import com.hightarun.backend.exception.InvalidDepartmentException;
import com.hightarun.backend.exception.UserNotFoundException;
import com.hightarun.backend.model.Department;
import com.hightarun.backend.model.Student;
import com.hightarun.backend.repository.DepartmentRepository;
import com.hightarun.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    // Save user
    public StudentRequestDTO saveUser(StudentRequestDTO studentRequestDTO) throws InvalidDepartmentException {
        Department dep = departmentRepository.findByDepartmentName(studentRequestDTO.getDepartmentName());
        if (dep != null) {
            Student student = Student.build(0, studentRequestDTO.getName(), studentRequestDTO.getRollNo(), studentRequestDTO.getEmailId(), dep);
            studentRepository.save(student);
            return convertEntityToDTO(student);
        } else {
            throw new InvalidDepartmentException("There is no " + studentRequestDTO.getDepartmentName() + " department");
        }
    }

    // Get list of all users
    public List<StudentRequestDTO> getAllUsers() {
        return studentRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    // Get user by id
    public StudentRequestDTO getUser(long id) throws UserNotFoundException {
        Student emp = studentRepository.findById(id);
        if (emp != null) {
            StudentRequestDTO empDTO = convertEntityToDTO(emp);
            return empDTO;
        } else {
            throw new UserNotFoundException("User Not found with id: " + id);
        }
    }

    // Update user
    public StudentRequestDTO updateUser(long id, StudentRequestDTO student) throws UserNotFoundException, InvalidDepartmentException {
        Student updateStudent = studentRepository.findById(id);
        Department dep = departmentRepository.findByDepartmentName(student.getDepartmentName());
        if (updateStudent != null) {
            if (dep != null) {
                updateStudent.setName(student.getName());
                updateStudent.setEmailId(student.getEmailId());
                updateStudent.setRollNo(student.getRollNo());
                updateStudent.setDepartment(dep);
                studentRepository.save(updateStudent);
                return convertEntityToDTO(updateStudent);
            } else {
                throw new InvalidDepartmentException("There is no " + student.getDepartmentName() + " department");
            }
        } else {
            throw new UserNotFoundException("User Not found with id: " + id);
        }
    }

    // Delete user
    public void deleteUser(long id) throws UserNotFoundException {
        Student delStudent = studentRepository.findById(id);
        if (delStudent != null) {
            studentRepository.delete(delStudent);
        } else {
            throw new UserNotFoundException("User Not found with id: " + id);
        }
    }

    // Entity to DTO converter
    private StudentRequestDTO convertEntityToDTO(Student student) {
        StudentRequestDTO studentRequestDTO = new StudentRequestDTO();
        studentRequestDTO.setId(student.getId());
        studentRequestDTO.setName(student.getName());
        studentRequestDTO.setRollNo(student.getRollNo());
        studentRequestDTO.setEmailId(student.getEmailId());
        studentRequestDTO.setDepartmentName(student.getDepartment().getDepartmentName());
        return studentRequestDTO;
    }
}
