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

    // Autowire the SmartDeviceService object
    @Autowired
    private SmartDeviceService smartDeviceService;

    /**
     * GET /devices/all - Fetches all devices
     * 1. Calls the required service method
     * 2. Adds proper annotation for GET mapping
     **/
    @GetMapping("/all")
    public List<SmartDevice> getAllDevices() {
        return smartDeviceService.getAllDevices();
    }

    /**
     * GET /devices/id/{id} - Fetches a device by ID
     * 1. Calls the required service method
     * 2. Adds proper annotation for GET mapping and attaches the required path variable to the method parameter
     **/
    @GetMapping("/id/{id}")
    public SmartDevice getDeviceById(@PathVariable Integer id) {
        return smartDeviceService.getDeviceById(id);
    }

    /**
     * POST /devices/add - Adds a new device
     * 1. Calls the required service method
     * 2. Adds proper annotation for POST mapping and attaches the required request body to the method parameter
     * 3. Surrounds InvalidStatusException with try-catch
     **/
//    @PostMapping("/add")
//    public void addDevice(@RequestBody DeviceDTO deviceDto) {
//        try {
//            smartDeviceService.addDevice(deviceDto);
//        } catch (InvalidStatusException e) {
//            // Handle exception, log it or return a meaningful response
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
    @PostMapping("/add")
    public void addDevice(@RequestBody DeviceDTO deviceDTO) throws InvalidStatusException {
        if (deviceDTO.getStatus().equalsIgnoreCase("On") ||deviceDTO.getStatus().equalsIgnoreCase("Off"))
         smartDeviceService.addDevice(deviceDTO);
        else
            throw new InvalidStatusException("Invalid Status");
        }

    /**
     * PUT /devices/changeStatus - Updates the status of a device
     * 1. Calls the required service method
     * 2. Adds proper annotation for PUT mapping and attaches the required request body to the method parameter
     * 3. Surrounds InvalidStatusException with try-catch
     **/
//    @PutMapping("/changeStatus")
//    public void updateDeviceStatus(@RequestBody DeviceDTO deviceDto) {
//        try {
//            smartDeviceService.updateDeviceStatus(deviceDto);
//        } catch (InvalidStatusException e) {
//            // Handle exception, log it or return a meaningful response
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
    @PutMapping("/changeStatus")
    public void updateDeviceStatus(@RequestBody DeviceDTO deviceDTO) throws InvalidStatusException{
        if (deviceDTO.getStatus().equalsIgnoreCase("On") ||deviceDTO.getStatus().equalsIgnoreCase("Off"))
            smartDeviceService.updateDeviceStatus(deviceDTO);
        else
            throw new InvalidStatusException("Invalid Status");
    }

    /**
     * DELETE /devices/delete/id/{id} - Deletes a device by ID
     * Creates the delete API after running the application
     **/
    @DeleteMapping("/delete/id/{id}")
    public void deleteDevice(@PathVariable Integer id) {
        smartDeviceService.deleteDevice(id);
    }
}
