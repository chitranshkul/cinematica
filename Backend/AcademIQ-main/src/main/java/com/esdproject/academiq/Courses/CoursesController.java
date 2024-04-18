package com.esdproject.academiq.Courses;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CoursesController {

    @Autowired
    private final CoursesServices coursesServices;

    @GetMapping("/courses/{facultyId}")
    public Optional<List<Courses>> getSalaryDetails(@PathVariable Integer facultyId) {
        System.out.println("@@@@@@@@@@@@@@@@@@ FUNCTION IS CALLING  @@@@@@@@@@@@@@@@@@@@@@@@");
        Optional<List<Courses>> details = coursesServices.getFacultyCourses(facultyId);
        System.out.println("@@@@@@@@@@@@@@@@@@ FUNCTION IS CALLED AND WORK IS DONE  @@@@@@@@@@@@@@@@@@@@@@@@");
        return details;
    }


    @PostMapping("/updateCourse")
    public String updateCourseDetails(@RequestBody Courses course_updated) {

        System.out.println("########################## FUNCTION IS CALLING  ##########################");
        Optional<Courses> course_details = coursesServices.setCourseDetails(course_updated);
        System.out.println("########################## FUNCTION IS CALLED AND WORK IS DONE  ##########################");

        return "Sucess";
    }
}
