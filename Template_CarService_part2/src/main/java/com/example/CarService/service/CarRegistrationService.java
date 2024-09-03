package com.example.CarService.service;

import com.example.CarService.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 1. Implement the interface Registration and Override the method registerCar() and getNewCar() in CarRegistrationService.
 * 2. Also,autowire car of type Vehicle and use it in method registerCar() and getNewCar().
 **/

@Service
public class CarRegistrationService implements Registration {
    @Autowired
    Vehicle vehicle;

    @Override
    public Boolean registerCar(String vehicleNo, String vehicleName, String CarDetails, String CarWork) {
        vehicle.createVehicle(vehicleNo, vehicleName, CarDetails, CarWork);
        return vehicle.saveVehicleDetails();
    }

    @Override
    public Vehicle getNewCar() {
        return this.vehicle;
    }
}
