package com.cn.homeControlSystem.service;

import com.cn.homeControlSystem.model.Room;
import com.cn.homeControlSystem.repositories.RoomRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    public void addRoom(Room room) {
        roomRepository.save(room);
    }



    public void deleteRoom(Integer id) {
        Room room = getRoomById(id);
        roomRepository.delete(room);
    }
}
