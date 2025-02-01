package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="students")
@Data
public class Student {
	public Student() {
		super();
	}
	
	public Student(int sid, String name, int age, String course, String address, String emailId, String contact) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.course = course;
		this.address = address;
		this.emailId = emailId;
		this.contact = contact;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int sid;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	private String name;
	
	private int age;
	
	private String course;
	
	private String address;
	
	private String emailId;
	
	private String contact;

}
