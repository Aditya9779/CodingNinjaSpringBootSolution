package com.cn.homeControlSystem.service;

import com.cn.homeControlSystem.model.Room;
import com.cn.homeControlSystem.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    // Autowire the RoomRepository object
    @Autowired
    private RoomRepository roomRepository;

    /**
     * Fetches all room records.
     **/
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    /**
     * Fetches a room record by id.
     **/
    public Room getRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    /**
     * Saves a room record.
     **/
    public void addRoom(Room room) {	// changed the return type to void
        roomRepository.save(room);
    }

    /**
     * Deletes a room record by id.
     **/
    public void deleteRoom(Integer id) {
//        roomRepository.deleteById(id);
    	 Room room = getRoomById(id);
         roomRepository.delete(room);
    }
}
