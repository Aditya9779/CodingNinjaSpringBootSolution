package com.CN.CarQuest.service;

import com.CN.CarQuest.communicator.ReviewServiceCommunicator;
import com.CN.CarQuest.dto.CarRequest;
import com.CN.CarQuest.dto.CarResponse;
import com.CN.CarQuest.dto.ReviewRequest;
import com.CN.CarQuest.dto.ReviewResponse;
import com.CN.CarQuest.model.Car;
import com.CN.CarQuest.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final ReviewServiceCommunicator reviewServiceCommunicator;

    public CarService(CarRepository carRepository, ReviewServiceCommunicator reviewServiceCommunicator) {
        this.carRepository = carRepository;
        this.reviewServiceCommunicator = reviewServiceCommunicator;
    }

    //    public CarResponse getCarById(String name, String authorizationHeader) {
//		Car car = carRepository.findById(name).orElseThrow(() ->
//				new RuntimeException("Car not found with id: " + name));
//		return CarResponse.builder().brand(car.getBrand()).color(car.getColor())
//				.price(car.getPrice()).modelYear(car.getModelYear()).name(car.getName()).build();
//    }
    public CarResponse getCarById(String name, String authorizationHeader) {
        Car car = carRepository.findById(name).orElseThrow(() ->
                new RuntimeException("Car not found with id: " + name));

        // Fetch reviews from the ReviewService and add them to the CarResponse
        String jwtTocken=authorizationHeader.substring(7);
        List<ReviewResponse> reviews = reviewServiceCommunicator.getReview(car.getName(), jwtTocken);
        List<String> review = new ArrayList<>();

            for (ReviewResponse x : reviews) {
                String reviewResponse = x.getReview();
                review.add(reviewResponse);

        }
        return CarResponse.builder()
                .brand(car.getBrand())
                .color(car.getColor())
                .price(car.getPrice())
                .modelYear(car.getModelYear())
                .name(car.getName())
                .reviews(review)
                .build();
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car updateCar(String name, CarRequest carDto) {
        Car existingCar = carRepository.findById(name).orElseThrow(() ->
                new RuntimeException("Car not found with id: " + name));
        existingCar.setName(carDto.getName());
        existingCar.setBrand(carDto.getBrand());
        existingCar.setPrice(carDto.getPrice());
        existingCar.setColor(carDto.getColor());
        existingCar.setModelYear(carDto.getModelYear());
        return carRepository.save(existingCar);
    }

    public void deleteCar(String name) {
        carRepository.deleteById(name);
    }

    public Car addCar(CarRequest carDto) {
        Car car = new Car();
        car.setName(carDto.getName());
        car.setBrand(carDto.getBrand());
        car.setPrice(carDto.getPrice());
        car.setColor(carDto.getColor());
        car.setModelYear(carDto.getModelYear());

        return carRepository.save(car);
    }

    public void addReview(ReviewRequest reviewRequest, String authorizationHeader) {
        // Delegate the review addition task to the ReviewServiceCommunicator
        reviewServiceCommunicator.addReview(reviewRequest, authorizationHeader);
    }
}
