package com.CN.CarQuest.controller;

import com.CN.CarQuest.dto.CarRequest;
import com.CN.CarQuest.dto.CarResponse;
import com.CN.CarQuest.dto.ReviewRequest;
import com.CN.CarQuest.model.Car;
import com.CN.CarQuest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    // Get all cars
    @GetMapping("/getAll")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // Get car by ID
    @GetMapping("/{name}")
    public CarResponse getCarById(@RequestHeader("Authorization") String authorizationHeader, @PathVariable String name) {
        return carService.getCarById(name, authorizationHeader);
    }

    // Create a new car
    @PostMapping("/add")
    public Car addCar(@RequestBody CarRequest car) {
        return carService.addCar(car);
    }

    @PostMapping("/addCarReview")
    public void addCarReview(@RequestBody ReviewRequest reviewRequest, @RequestHeader("Authorization") String authorizationHeader){
        carService.addReview(reviewRequest, authorizationHeader);
    }

    // Update an existing car
    @PutMapping("/{name}") //by name
    public Car updateCar(@PathVariable String name, @RequestBody CarRequest carDto) {
        return carService.updateCar(name, carDto);
    }

    // Delete a car
    @DeleteMapping("/{name}")
    public void deleteCar(@PathVariable String name) {
        carService.deleteCar(name);
    }
}
