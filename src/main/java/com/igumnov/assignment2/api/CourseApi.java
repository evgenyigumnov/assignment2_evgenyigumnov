package com.igumnov.assignment2.api;

import com.igumnov.assignment2.model.Course;
import com.igumnov.assignment2.model.Degree;
import com.igumnov.assignment2.service.StudentSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "courseApi")
@RequestMapping("/api/course")
public class CourseApi {
    @Autowired
    private StudentSystem studentSystem;

    @RequestMapping( method = RequestMethod.GET)
    public Iterable<Course> get() {
        return studentSystem.getCourses();
    }
}