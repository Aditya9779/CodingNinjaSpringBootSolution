package com.example.StudentManagementSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.service.StudentsService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class studentsController {
	
	@Autowired
	StudentsService studentsService;
	
	@GetMapping("/test")
	public String test(){
		return "test";
	}
	
	@GetMapping("/getStudents")
	public List<Student> getStudents(){
		return studentsService.getStudents();
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentsService.addStudent(student);
	}
	
	@DeleteMapping("/deleteStudent/{sid}")
	public String deleteStudent(@PathVariable int sid) {
		if(studentsService.deleteStudent(sid))
			return "Deleted Student SID: "+ sid;
		return "Student does not exist!";
	}
}
