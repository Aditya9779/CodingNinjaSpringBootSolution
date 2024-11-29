package com.cn.homeControlSystem.actuator;

import com.cn.homeControlSystem.repositories.SmartDevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "deviceStatus")
public class Actuator {

    @Autowired
    SmartDevicesRepository smartDeviceRepository;

    Map<String, String> data = new HashMap<>();
    @ReadOperation
    public Map<String, String> getDeviceStatus() {
        smartDeviceRepository.findAll().forEach(device -> {
            data.put(device.getName(), device.getStatus());
        });
        return data;
    }
}
