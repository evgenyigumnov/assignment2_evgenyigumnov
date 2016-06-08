package com.igumnov.assignment2.dao;

import com.igumnov.assignment2.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDAO extends CrudRepository<Student, Long> {

}
