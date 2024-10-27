package com.example.socialMedia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialMedia.model.Connection;
import com.example.socialMedia.repository.ConnectionDal;

@Service
public class ConnectionService {
	
	@Autowired
	ConnectionDal connectionDao;
	
	public List<Connection> getConnections() {
		return connectionDao.findAll();
	}

	public List<Connection> getConnectionsByCompany(String company) {
		return connectionDao.findByCompany(company);
	}

	public Connection addConnection(Connection connection) {
		return connectionDao.save(connection);
}

}
