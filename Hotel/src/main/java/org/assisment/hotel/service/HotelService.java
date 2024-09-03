package org.assisment.hotel.service;

import org.assisment.hotel.domain.Hotel;
import org.springframework.stereotype.Service;

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
        return hotelMap.get(id);
    }

    public List<Hotel> getAllHotels() {
        return hotelsList;
    }


    public void deleteHotelById(String id) {
        Hotel getHotel = getHotelById(id); //This was the upper function for the finding by the id
        hotelsList.remove(getHotel);
        hotelMap.remove(id);
    }
}
