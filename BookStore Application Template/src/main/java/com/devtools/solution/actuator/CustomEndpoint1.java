package com.devtools.solution.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "database")
public class CustomEndpoint1 {

    @ReadOperation
    public Map<String, String> getDbInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("database", "MySQL");
        return map;
    }
}
