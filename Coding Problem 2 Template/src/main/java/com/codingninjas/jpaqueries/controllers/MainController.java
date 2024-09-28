package com.codingninjas.jpaqueries.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.jpaqueries.entities.CourseMarks;
import com.codingninjas.jpaqueries.entities.Student;
import com.codingninjas.jpaqueries.services.MainService;

@RestController
public class MainController {

	@Autowired
	MainService service;

	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getStudentById(id);
	}

	@PostMapping("/student")
	public void saveStudent(@RequestBody Student student) {
		System.out.println("student name is "+ student.getName());
		service.setStudent(student);
	}

	@PostMapping("/student/{id}/courses_marks")
	public void saveCoursesWithMarks(@RequestBody List<CourseMarks> courses,@PathVariable int id) {
		service.setCourses(courses,id);
	}

	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}

	@GetMapping("/students/{course}")
	public List<Student> getAllStudentsByCourse(@PathVariable String course){
		return service.getAllStudentsByCourse(course);
	}

	/*
	 1. Write a controller method with name getCoursesNameByStudentID, which returns a List of String (List<String>)
	   of the courses name enrolled by a Student.
	 2. You need to use GET mapping with this path -> "".

	 		public List<String> getCoursesNameByStudentID(@PathVariable int id){

	 		}
	 */
	@GetMapping("/students/{id}/courses")
	public List<String> getCoursesNameByStudentId(@PathVariable Integer id){
		return service.getCoursesNameByStudentId(id);
	}

}
