package com.igumnov.assignment2.service;


import javax.annotation.PostConstruct;


import com.igumnov.assignment2.dao.CourseDAO;
import com.igumnov.assignment2.dao.DegreeDAO;
import com.igumnov.assignment2.dao.StudentDAO;
import com.igumnov.assignment2.model.Course;
import com.igumnov.assignment2.model.Degree;
import com.igumnov.assignment2.model.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("studentSystem")
public class StudentSystem {
    final static Logger logger = Logger.getLogger(StudentSystem.class);

    @Autowired
    private CourseDAO courseRepository;

    @Autowired
    private DegreeDAO degreeRepository;

    @Autowired
    private StudentDAO studentRepository;


    public void setStudentLocation(Long studentId, String latitude, String longitude) {
        Student student = studentRepository.findOne(studentId);
        student.setLatitude(latitude);
        student.setLongitude(longitude);
        studentRepository.save(student);
    }

    public Long addStudent(String name) {
        Student student = new Student();
        student.setName(name);
        return studentRepository.save(student).getId();
    }

    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findOne(studentId);
    }

    @PostConstruct
    public void init() {
        logger.info("ApiService.init()");
        if (!getStudents().iterator().hasNext()) {
            Long studentJohnId = addStudent("John Smith");
            Long studentAmandaId = addStudent("Amanda Lucky");

            Long courseMathematicId = addCourse("Mathematic");
            Long courseMusicId = addCourse("Music");

            Long degreeMasterId = addDegree("Master");
            addCourseToDegree(courseMathematicId, degreeMasterId);
            addCourseToDegree(courseMusicId, degreeMasterId);

            addCourseToStudent(courseMathematicId, studentJohnId);
            addCourseToStudent(courseMusicId, studentJohnId);
            addCourseToStudent(courseMusicId, studentAmandaId);
        }
    }

    public void addCourseToStudent(Long courseMathematicId, Long studentId) {
        Course course = courseRepository.findOne(courseMathematicId);
        Student student = studentRepository.findOne(studentId);
        course.getStudents().add(student);
        courseRepository.save(course);
    }

    public void addCourseToDegree(Long courseMathematicId, Long degreeId) {
        Course course = courseRepository.findOne(courseMathematicId);
        Degree degree  = degreeRepository.findOne(degreeId);
        degree.getCourses().add(course);
        degreeRepository.save(degree);
    }

    public Long addDegree(String name) {
        Degree degree = new Degree();
        degree.setName(name);
        return degreeRepository.save(degree).getId();
    }

    public Long addCourse(String name) {
        Course course = new Course();
        course.setName(name);
        return courseRepository.save(course).getId();
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.findOne(courseId);
    }

    public Degree getDegreeById(Long degreeId) {
        return degreeRepository.findOne(degreeId);
    }

    public Iterable<Degree> getDegrees() {
        return degreeRepository.findAll();
    }

    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }
}
