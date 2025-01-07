package com.example.socialMedia.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialMedia.model.Connection;

@Repository
public interface ConnectionDal extends JpaRepository<Connection, Integer>{
	List<Connection> findByCompany(String company);
}
