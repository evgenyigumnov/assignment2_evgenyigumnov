package com.igumnov.assignment2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@JsonIgnoreProperties({ "students" })
@Entity
public class Course {


    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_course")
    private List<Student> students;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
