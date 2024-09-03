package org.assisment.hotel.service;

import org.assisment.hotel.domain.Hotel;
import org.assisment.hotel.exception.ErrorExceptionIdNotFound;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {
    List<Hotel> hotelsList = new ArrayList<Hotel>();
    Map<String, Hotel> hotelMap = new HashMap<String, Hotel>();

    public void createHotel(Hotel hotel) {
        hotelsList.add(hotel);
        hotelMap.put(hotel.getId(), hotel);
    }

    public Hotel getHotelById(String id) {
        if (ObjectUtils.isEmpty(hotelMap.get(id))) {
            throw new ErrorExceptionIdNotFound("This id is not found " + id);
        }
        return hotelMap.get(id);
    }

    public List<Hotel> getAllHotels() {
        return hotelsList;
    }


    public void removeHotelById(String id) {
        Hotel getHotel = getHotelById(id); //This was the upper function for the finding by the id
        hotelsList.remove(getHotel);
        hotelMap.remove(id);
    }

    public void update(Hotel updatedHotel) {
        Hotel existing = getHotelById(updatedHotel.getId()); //Get the old hotel by id
        hotelsList.remove(existing); //remove the old hotel from the list
        hotelsList.add(updatedHotel); //update the hotel
        hotelMap.put(updatedHotel.getId(), updatedHotel); //use the map function to update the existing
        //hotel to according their id
    }

    public void updatePath(String id, Hotel updatedHotel) {
        Hotel existing = getHotelById(id);
        hotelsList.remove(existing);
        hotelsList.add(updatedHotel); //update the hotel
        hotelMap.put(existing.getId(), updatedHotel);
    }
}
