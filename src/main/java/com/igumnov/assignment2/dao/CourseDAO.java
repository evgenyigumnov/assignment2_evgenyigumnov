package com.igumnov.assignment2.dao;

import com.igumnov.assignment2.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseDAO extends CrudRepository<Course, Long> {

}
