package com.igumnov.assignment2;

import com.igumnov.assignment2.model.Student;
import com.igumnov.assignment2.service.StudentSystem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppServer.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0",  "spring.jpa.hibernate.ddl-auto:create",
        "spring.datasource.url: jdbc:hsqldb:mem:test2", "spring.datasource.driver-class-name: org.hsqldb.jdbcDriver"})
@DirtiesContext
public class StudentSystemTest {

    @Autowired
    private StudentSystem studentSystem;


    @Test
    public void testAddStudent()  {

        Long studentId  = studentSystem.addStudent("New student");
        assertEquals(studentSystem.getStudentById(studentId).getName(), "New student");
    }

    @Test
    public void testSetLocation()  {

        Long studentId  = studentSystem.addStudent("New student2");
        studentSystem.setStudentLocation(studentId,"123","456");
        Student student = studentSystem.getStudentById(studentId);

        assertEquals(student.getLatitude(), "123");
        assertEquals(student.getLongitude(), "456");
    }
}