package com.igumnov.assignment2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {


    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy="students", fetch = FetchType.EAGER)
    private List<Course> courses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Degree> degrees;

    @Column
    private String longitude;

    @Column
    private String latitude;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

    public List<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<Degree> degrees) {
        this.degrees = degrees;
    }
}
