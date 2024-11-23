package com.codingninjas.EVotingSystem.entities;

import jakarta.persistence.*;
import org.springframework.data.repository.cdi.Eager;

@Entity
public class ElectionChoice {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;

	@ManyToOne(cascade=CascadeType.ALL)
	private Election election;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}
}
