package com.example.CarService.repository;

import com.example.CarService.domain.Car;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public class CarDAO implements DAO<Car> {
    private List<Car> carList = new ArrayList<>();

    private int currentId = 0;

    @Override
    public int save(Car car) {
        currentId++;
        car.setCarId(currentId);
        carList.add(car);
        return currentId;
    }
}
