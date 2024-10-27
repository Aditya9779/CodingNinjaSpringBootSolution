package com.cn.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cn.hotel.model.Hotel;


public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
