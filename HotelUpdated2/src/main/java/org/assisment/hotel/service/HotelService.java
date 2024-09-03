package org.assisment.hotel.service;

import org.assisment.hotel.communicator.RatingServiceCommunicator;
import org.assisment.hotel.domain.Hotel;
import org.assisment.hotel.exception.ErrorExceptionIdNotFound;
import org.assisment.hotel.exception.HotelAlreadyPresent;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RatingServiceCommunicator ratingServiceCommunicator;

    public void createHotel(Hotel hotel) {
        if (hotelMap.containsKey(hotel.getId())) {
            throw new HotelAlreadyPresent("Hotel is already present with this id " + hotel.getId());
        }
        hotelsList.add(hotel);
        hotelMap.put(hotel.getId(), hotel);

        /*Add in the different Second application to create in rating application*/

        /*Its accepting the prarmeter of map to add the rating*/
        Map<String, Long> ratingMap = new HashMap<>();
        ratingMap.put(hotel.getId(), hotel.getRating());
        ratingServiceCommunicator.addFunction(ratingMap);

    }

    public Hotel getHotelById(String id) {
        if (ObjectUtils.isEmpty(hotelMap.get(id))) {
            throw new ErrorExceptionIdNotFound("This id is not found " + id);
        }
        Hotel currentHotel = hotelMap.get(id);
        //Rest service to check the rating is updated or not
        long updateRating = ratingServiceCommunicator.getIdRating(id);
        currentHotel.setRating(updateRating);
        return currentHotel;
    }

    public List<Hotel> getAllHotels() {
        return hotelsList;
    }


    public void removeHotelById(String id) {
        Hotel getHotel = getHotelById(id); //This was the upper function for the finding by the id
        hotelsList.remove(getHotel);
        hotelMap.remove(id);
        ratingServiceCommunicator.deleteFuntion(id);
    }

    public void update(Hotel updatedHotel) {
        Hotel existing = getHotelById(updatedHotel.getId()); //Get the old hotel by id
        hotelsList.remove(existing); //remove the old hotel from the list
        hotelsList.add(updatedHotel); //update the hotel
        hotelMap.put(updatedHotel.getId(), updatedHotel); //use the map function to update the existing
        //hotel to according their id
        Map<String, Long> map = new HashMap<>();
        map.put(updatedHotel.getId(), updatedHotel.getRating());
        ratingServiceCommunicator.updateFunction(map);
    }

    public void updatePath(String id, Hotel updatedHotel) {
        Hotel existing = getHotelById(id);
        hotelsList.remove(existing);
        hotelsList.add(updatedHotel); //update the hotel
        hotelMap.put(existing.getId(), updatedHotel);
    }
}
