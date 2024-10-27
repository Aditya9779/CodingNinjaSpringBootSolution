package com.cn.homeControlSystem.service;

//import com.cn.homeControlSystem.exception.InvalidStatusException;
import com.cn.homeControlSystem.dto.DeviceDTO;
import com.cn.homeControlSystem.excpetion.InvalidStatusException;
import com.cn.homeControlSystem.model.SmartDevice;
import com.cn.homeControlSystem.repositories.SmartDevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartDeviceService {

    // Autowire the SmartDevicesRepository object
    @Autowired
    private SmartDevicesRepository smartDevicesRepository;

    /**
     * Fetches all device records.
     **/
    public List<SmartDevice> getAllDevices() {
        return smartDevicesRepository.findAll();
    }

    /**
     * Fetches a device record by id.
     **/
    public SmartDevice getDeviceById(Integer id) {
        return smartDevicesRepository.findById(id).orElse(null);
    }

    /**
     * Saves a device record.
     * Throws InvalidStatusException if the status is not "On" or "Off".
     **/
    public void addDevice(DeviceDTO deviceDTO) throws InvalidStatusException {
//        validateStatus(deviceDTO.getStatus());
        SmartDevice smartDevice = new SmartDevice();
        smartDevice.setName(deviceDTO.getName());
        smartDevice.setType(deviceDTO.getType());
        smartDevice.setStatus(deviceDTO.getStatus());
        smartDevice.setRoomId(deviceDTO.getRoomId());
        smartDevicesRepository.save(smartDevice);
    }
    public void updateDeviceStatus(DeviceDTO deviceDTO) { //throws
    	SmartDevice smartDevice=smartDevicesRepository.findByName(deviceDTO.getName());
        smartDevice.setStatus(deviceDTO.getStatus());
        smartDevice.setRoomId(smartDevice.getRoomId());

        smartDevicesRepository.save(smartDevice);
    }

    /**
     * Deletes a device record by id.
     **/
    public void deleteDevice(Integer id) {
        smartDevicesRepository.deleteById(id);
    }


}
