package com.example.socialMedia.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="connections")
@Data
public class Connection {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	

	private String name;
	

	private String emailId;
	

	private String company;
	

	private String username;
	

	private int level;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
