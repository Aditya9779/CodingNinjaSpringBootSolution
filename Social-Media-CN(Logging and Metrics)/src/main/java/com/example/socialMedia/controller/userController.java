package com.example.socialMedia.controller;

import com.example.socialMedia.model.Connection;
import com.example.socialMedia.repository.ConnectionDal;
import com.example.socialMedia.service.ConnectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class userController {

    private static final Logger logger = LoggerFactory.getLogger(userController.class);
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
        logger.info("Starting to get the connections");
        List<Connection> responseConnections = connectionService.getConnections();
        logger.info("Response :" + responseConnections);
        return responseConnections;
    }

    @GetMapping("/connections/{company}")
    public List<Connection> getConnectionsByCompany(@PathVariable String company) {
        List<Connection> reConnections = connectionService.getConnectionsByCompany(company);
        try {
            if (reConnections.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            logger.error("Recieved the empty response");
        }
        return reConnections;
    }

    @PostMapping("/add")
    public Connection addConnection(@RequestBody Connection connection) {
        return connectionService.addConnection(connection);
    }

}
