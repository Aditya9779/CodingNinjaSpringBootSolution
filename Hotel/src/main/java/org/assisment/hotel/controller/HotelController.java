package org.assisment.hotel.controller;

import org.assisment.hotel.domain.Hotel;
import org.assisment.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;


    @PostMapping("/create")
    public void createHotel(@RequestBody Hotel hotel) {
        hotelService.createHotel(hotel);
    }

    @GetMapping("/id/{id}")
    public Hotel getHotelById(@PathVariable String id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping("/getAllHotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }
    @DeleteMapping("/remove/id/{id}")
    public void deleteHotelById(@PathVariable String id){
        hotelService.deleteHotelById(id);
    }


}
