package com.igumnov.assignment2.api;

import com.igumnov.assignment2.model.Student;
import com.igumnov.assignment2.service.StudentSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "studentApi")
@RequestMapping("/api/student")
public class StudentApi {

    @Autowired
    private StudentSystem studentSystem;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Student> get() {
        return studentSystem.getStudents();
    }

    @RequestMapping(value = "/{studentId}/location", method = RequestMethod.PUT)
    public Location update(@PathVariable("studentId") Long studentId, @RequestBody Location location) {
        studentSystem.setStudentLocation(studentId, location.getLatitude(), location.getLongitude());
        return location;
    }

}
