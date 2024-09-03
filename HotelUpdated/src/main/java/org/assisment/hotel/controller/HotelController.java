package org.assisment.hotel.controller;

import jakarta.validation.Valid;
import org.assisment.hotel.domain.Hotel;
import org.assisment.hotel.exception.BadException;
import org.assisment.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;


    @PostMapping("/create")
    public void createHotel(@Valid @RequestBody Hotel hotel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //General Exception
//            throw new RuntimeException("Request not valid");
            throw new BadException("Request not valid");

        }
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
    public void deleteHotelById(@PathVariable String id) {
        hotelService.removeHotelById(id);
    }

    //Simple update
    @PutMapping("/update")
    public void update(@RequestBody Hotel updatedHotel) {
        hotelService.update(updatedHotel);
    }

    //Update by the pathvarible

    @PutMapping("/updatePath/id/{id}")
    public void updatePath(@PathVariable String id, @RequestBody Hotel updatedHotel) {
        hotelService.updatePath(id, updatedHotel);
    }

}
