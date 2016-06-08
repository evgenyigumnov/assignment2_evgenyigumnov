package com.igumnov.assignment2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@JsonIgnoreProperties({ "courses" })
@Entity
public class Degree {


    @Id
    @GeneratedValue
    private Long id;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Course> courses;

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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
