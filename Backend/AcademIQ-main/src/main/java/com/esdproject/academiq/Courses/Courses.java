package com.esdproject.academiq.Courses;

import com.esdproject.academiq.department.Department;
import com.esdproject.academiq.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;


    @Column(name = "course_code", length = 100, unique = true,nullable = false)
    private String course_code;

    @Column(name = "name", length = 100,nullable = false )
    private String name;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Column(name = "year", length = 100,nullable = false)
    private String year;

    @Column(name = "term", length = 100, nullable = false)
    private String term;

    @Column(name = "credits", length = 100 ,nullable = false)
    private String credits;

    @Column(name = "capacity", length = 100, nullable = false)
    private String capcity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getCapcity() {
        return capcity;
    }

    public void setCapcity(String capcity) {
        this.capcity = capcity;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id")
    private Employee employee;


}
