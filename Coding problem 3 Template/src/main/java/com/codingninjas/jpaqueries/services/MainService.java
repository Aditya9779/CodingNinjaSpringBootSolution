package com.codingninjas.jpaqueries.services;

import com.codingninjas.jpaqueries.entities.Course;
import com.codingninjas.jpaqueries.entities.CourseMarks;
import com.codingninjas.jpaqueries.entities.Grade;
import com.codingninjas.jpaqueries.entities.Student;
import com.codingninjas.jpaqueries.repository.CourseRepository;
import com.codingninjas.jpaqueries.repository.GradeRepository;
import com.codingninjas.jpaqueries.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    GradeRepository gradeRepository;

	/*
	 1. create a method with name getAverageGradesOfStudent which takes "int id" as input and returns
        the average grade of the given student id in double.

     2. call the required method from gradeRepository.

        	public double getAverageGradesOfStudent(int id) {
			}
	 */


    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public void setStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).get();
    }

    public void setCourses(List<CourseMarks> courses, int id) {
        Student student = this.getStudentById(id);

        for (CourseMarks courseMarks : courses) {
            Course course = this.getCourseByName(courseMarks.getCourse()).orElse(new Course());
            Grade grade = new Grade();
            grade.setStudent(student);
            grade.setMarks(courseMarks.getMarks());
            grade.setCourse(course);
            course.setName(courseMarks.getCourse());
            course.setStudentMarks(courseMarks.getMarks());
            course.getStudents().add(student);
            student.getCourses().add(course);
            gradeRepository.save(grade);
            courseRepository.save(course);
            studentRepository.save(student);
        }
    }

    private Optional<Course> getCourseByName(String course) {
        return courseRepository.findByName(course);
    }

    public List<Student> getAllStudentsByCourse(String course) {
        return studentRepository.findAllByCourses_name(course);
    }

    public List<String> getCoursesNameByStudentId(int id) {
        return courseRepository.getCoursesByStudentId(this.getStudentById(id));
    }

    public double getAverageGradesOfStudent(Integer id) {
        return gradeRepository.findAverageGradeByStudentId(id);
    }
}
