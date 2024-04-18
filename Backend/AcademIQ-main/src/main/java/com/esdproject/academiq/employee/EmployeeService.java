package com.esdproject.academiq.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;


public Optional<Employee> getEmployeeDetails(Integer facultyId) {
    // Extract faculty ID from token
    // Fetch salary details for the faculty
    System.out.println("************************************************");
    Optional<Employee> employeeOptional = employeeRepository.findById(facultyId);

    return employeeOptional;
}

public Optional<Employee> setEmployeeDetails(Employee updatedEmployee) {
        // Extract faculty ID from token
        // Fetch salary details for the faculty
        System.out.println("************************************************");
        Optional<Employee> employee_details = employeeRepository.findById( updatedEmployee.getId());

    if (employee_details.isPresent()) {
        Employee employeeToUpdate = employee_details.get();
        System.out.println("##############################################");

        System.out.println("##############################################");
        employeeToUpdate.setFirst_name(updatedEmployee.getFirst_name());
        employeeToUpdate.setLast_name(updatedEmployee.getLast_name());
        employeeToUpdate.setEmail(updatedEmployee.getEmail());
        employeeToUpdate.setTitle(updatedEmployee.getTitle());
//        employeeToUpdate.setPhotographPath(updatedEmployee.getPhotographPath());
//        employeeToUpdate.setDepartment(updatedEmployee.getDepartment());
        employeeRepository.save(employeeToUpdate);
    } else {
        // Handle if employee is not found
        throw new IllegalArgumentException("Employee not found with ID: " + updatedEmployee.getId());
    }


        return employee_details;
    }


}
