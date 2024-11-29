package com.cn.homeControlSystem.controller;

import com.cn.homeControlSystem.dto.DeviceDTO;
import com.cn.homeControlSystem.excpetion.InvalidStatusException;
import com.cn.homeControlSystem.model.SmartDevice;
import com.cn.homeControlSystem.service.SmartDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DevicesController {
    @Autowired
    private SmartDeviceService smartDeviceService;

    @GetMapping("/all")
    public List<SmartDevice> getAllDevices() {
        return smartDeviceService.getAllDevices();
    }

    @GetMapping("/id/{id}")
    public SmartDevice getDeviceById(@PathVariable Integer id) {
        return smartDeviceService.getDeviceById(id);
    }

    @PostMapping("/add")
    public void addDevice(@RequestBody DeviceDTO deviceDTO) throws InvalidStatusException {
        if (deviceDTO.getStatus().equalsIgnoreCase("On") ||deviceDTO.getStatus().equalsIgnoreCase("Off"))
         smartDeviceService.addDevice(deviceDTO);
        else
            throw new InvalidStatusException("Invalid Status");
        }


    @PutMapping("/changeStatus")
    public void updateDeviceStatus(@RequestBody DeviceDTO deviceDTO) throws InvalidStatusException{
        if (deviceDTO.getStatus().equalsIgnoreCase("On") ||deviceDTO.getStatus().equalsIgnoreCase("Off"))
            smartDeviceService.updateDeviceStatus(deviceDTO);
        else
            throw new InvalidStatusException("Invalid Status");
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteDevice(@PathVariable Integer id) {
        smartDeviceService.deleteDevice(id);
    }
}
