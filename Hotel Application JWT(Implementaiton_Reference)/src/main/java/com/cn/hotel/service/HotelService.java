package com.cn.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.hotel.dto.HotelRequest;
import com.cn.hotel.model.Hotel;
import com.cn.hotel.repository.HotelRepository;

@Service
public class HotelService {

	private final HotelRepository hotelRepository;

	public HotelService(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).get();
    }

    public Hotel createHotel(HotelRequest hotelRequest) {
    	Hotel hotel = new Hotel();
    	hotel.setCity(hotelRequest.getCity());
    	hotel.setName(hotelRequest.getName());
    	hotel.setRating(hotelRequest.getRating());
    	
       return hotelRepository.save(hotel);
    }

    public void deleteHotelById(Long id) {
    	hotelRepository.deleteById(id);
    }

}
