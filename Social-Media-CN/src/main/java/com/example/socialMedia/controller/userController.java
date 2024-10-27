package com.example.socialMedia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialMedia.dto.ConnectionResponseDto;
import com.example.socialMedia.model.Connection;
import com.example.socialMedia.repository.ConnectionDal;
import com.example.socialMedia.service.ConnectionService;

@RestController
@RequestMapping("/ninjas")
public class userController {
	
	@Autowired
	ConnectionService connectionService;
	
	@Autowired
	ConnectionDal connectionDao;
	
	@GetMapping("/test")
	public String test() {
		return " dev hello test success!";
	}
	
	@GetMapping("/connections")
	public List<Connection> getConnections() {
		return connectionService.getConnections();
	}
	
	@GetMapping("/connections/{company}")
	public List<Connection> getConnectionsByCompany(@PathVariable String company){
		return connectionService.getConnectionsByCompany(company);
	}
	
	@PostMapping("/add")
	public Connection addConnection(@RequestBody Connection connection) {
		return connectionService.addConnection(connection);
	}
	
}
