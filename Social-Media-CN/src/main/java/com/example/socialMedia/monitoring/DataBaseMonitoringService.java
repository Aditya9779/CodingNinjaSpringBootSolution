package com.example.socialMedia.monitoring;

import com.example.socialMedia.repository.ConnectionDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataBaseMonitoringService implements HealthIndicator {
    private static final String DATABASE_NAME = "Connections Database";
    @Autowired
    ConnectionDal connectionDal;

    @Override
    public Health health() {
        Map<String, Object> details = new HashMap<>();

        if (isDatabaseHealthy()) {
            details.put("status", "up");
            details.put("message", "is up and running");
            return Health.up().withDetails(details).build();
        } else {
            details.put("status", "down");
            details.put("message", "is down and not running");
            return Health.down().withDetails(details).build();
        }
    }

    private boolean isDatabaseHealthy() {
        try {
            connectionDal.findById(1);
            return true;
        } catch (Exception e) {
            return false; // Currently hardcoded for demonstration
        }
    }
}
