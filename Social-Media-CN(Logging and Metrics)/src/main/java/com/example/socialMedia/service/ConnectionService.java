package com.example.socialMedia.service;

import java.util.List;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialMedia.model.Connection;
import com.example.socialMedia.repository.ConnectionDal;

@Service
public class ConnectionService {

	@Autowired
	private ConnectionDal connectionDao;

	// Declare the counter for connection calls
	private Counter connectionCallCounter;

	// Constructor to inject CompositeMeterRegistry and initialize the counter
	@Autowired
	public ConnectionService(CompositeMeterRegistry meterRegistry) {
		this.connectionCallCounter = meterRegistry.counter("connection.call.counter");
	}

	// Method to get all connections and increment the counter
	public List<Connection> getConnections() {
		connectionCallCounter.increment();
		return connectionDao.findAll();
	}

	// Method to get connections by company
	public List<Connection> getConnectionsByCompany(String company) {
		return connectionDao.findByCompany(company);
	}

	// Method to add a new connection
	public Connection addConnection(Connection connection) {
		return connectionDao.save(connection);
	}
}
