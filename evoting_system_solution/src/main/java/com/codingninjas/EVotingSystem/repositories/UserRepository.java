package com.codingninjas.EVotingSystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingninjas.EVotingSystem.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByName(String userName);

}
