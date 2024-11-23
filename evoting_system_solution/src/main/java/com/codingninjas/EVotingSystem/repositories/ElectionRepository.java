package com.codingninjas.EVotingSystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingninjas.EVotingSystem.entities.Election;

public interface ElectionRepository extends JpaRepository<Election, Long> {

	Optional<Election> findByName(String electionName);

}
