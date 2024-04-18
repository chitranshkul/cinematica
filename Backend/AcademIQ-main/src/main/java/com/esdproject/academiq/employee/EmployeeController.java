package com.esdproject.academiq.employee;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
@PreAuthorize("hasRole('EMPLOYEE')")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    @GetMapping("/employee/{facultyId}")
    public Optional<Employee> getEmployeeDetails(@PathVariable Integer facultyId) {
//        System.out.println(facultyId);
        // Extract faculty ID from token
        //Integer facultyId = TokenUtil.extractFacultyId(token);
        // Fetch salary details for the faculty
        Optional<Employee> details = employeeService.getEmployeeDetails(facultyId);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return details;
    }

    @PostMapping("/updateFaculty")
    public String updateFacultyDetails(@RequestBody Employee employee_updated) {

        Optional<Employee> employee_details = employeeService.setEmployeeDetails(employee_updated);

        return "Sucess";
    }
}
