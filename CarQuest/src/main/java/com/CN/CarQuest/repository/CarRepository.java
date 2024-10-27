package com.CN.CarQuest.repository;

import com.CN.CarQuest.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, String> {

}
