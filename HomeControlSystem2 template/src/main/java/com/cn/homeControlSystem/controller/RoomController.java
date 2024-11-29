package com.cn.homeControlSystem.controller;

import com.cn.homeControlSystem.model.Room;
import com.cn.homeControlSystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/add")
    public void addRoom(@RequestBody Room room){
    roomService.addRoom(room);
    }

    @GetMapping("/id/{id}")
    public Room getRoomById(@PathVariable(name = "id")Integer id){
        return roomService.getRoomById(id);
    }

    @GetMapping("/all")
    public List<Room> getAllRooms(){
    return roomService.getAllRooms();
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteRoom(@PathVariable(name = "id") Integer id){
        roomService.deleteRoom(id);
    }

}
