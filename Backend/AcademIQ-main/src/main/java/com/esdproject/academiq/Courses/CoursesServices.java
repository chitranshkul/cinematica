package com.esdproject.academiq.Courses;

import com.esdproject.academiq.employee.Employee;
import com.esdproject.academiq.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursesServices {

    @Autowired
    private final CoursesRepositry coursesRepositry ;
    private final EmployeeRepository employeeRepository ;

    public Optional<List<Courses>> getFacultyCourses(Integer facultyId) {
        System.out.println("************************************************");
        Optional<Employee> employeeOptional = employeeRepository.findById(facultyId);
        System.out.println("---------------------------------------------------");
        Optional<List<Courses>> employeeCourses = Optional.empty();
        System.out.println("#####################################################");
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            // Fetching salary details for the employee
            try {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                employeeCourses = coursesRepositry.findByEmployee(employee);
                System.out.println("=================================================");
                return employeeCourses;
            }
            catch(Exception ex) {
                System.out.println("************************************************");
                ex.printStackTrace();
            }

        }
//        System.out.println(optionalSalary);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        return employeeCourses;
    }


    public Optional<Courses> setCourseDetails(Courses updatedCourses) {
        // Extract faculty ID from token
        // Fetch salary details for the faculty
        System.out.println("************************************************");
        Optional<Courses> course_details = coursesRepositry.findById( updatedCourses.getId());

        if (course_details.isPresent()) {

            Courses courseToUpdate = course_details.get();

            courseToUpdate.setCourse_code(updatedCourses.getCourse_code());
            courseToUpdate.setCapcity(updatedCourses.getCapcity());
            courseToUpdate.setCredits(updatedCourses.getCredits());
            courseToUpdate.setName(updatedCourses.getName());
            courseToUpdate.setTerm(updatedCourses.getTerm());
            courseToUpdate.setYear(updatedCourses.getYear());
            courseToUpdate.setDescription(updatedCourses.getDescription());

            coursesRepositry.save(courseToUpdate);
        } else {
            // Handle if employee is not found
            throw new IllegalArgumentException("Employee not found with ID: " + updatedCourses.getId());
        }


        return course_details;
    }


}
