package com.cn.homeControlSystem.controller;

import com.cn.homeControlSystem.model.Room;
import com.cn.homeControlSystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    // Autowire the RoomService object
    @Autowired
    private RoomService roomService;

    /**
     * POST /room/add - Adds a new room
     * 1. Calls the required service method
     * 2. Adds proper annotation for POST mapping and attaches the required request body to the method parameter
     **/
    @PostMapping("/add")
    public void addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
    }

    /**
     * GET /room/id/{id} - Fetches a room by ID
     * 1. Calls the required service method
     * 2. Adds proper annotation for GET mapping and attaches the required path-variable to the method parameter
     **/
    @GetMapping("/id/{id}")
    public Room getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }

    /**
     * GET /room/all - Fetches all rooms
     * 1. Calls the required service method
     * 2. Adds proper annotation for GET mapping
     **/
    @GetMapping("/all")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    /**
     * DELETE /room/delete/id/{id} - Deletes a room by ID
     * 1. Calls the required service method
     * 2. Adds proper annotation for DELETE mapping and attaches the required path-variable to the method parameter
     **/
    @DeleteMapping("/delete/id/{id}")
    public void deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
    }
}
