package com.CN.Gym.controller;

import com.CN.Gym.dto.GymDto;
import com.CN.Gym.model.Gym;
import com.CN.Gym.service.GymService;
import com.CN.Gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/gym")
public class GymController {

    @Autowired
    private GymService gymService;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public List<Gym> getAllGyms() {
        return gymService.getAllGyms();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public Gym getGymById(@PathVariable Long id){
        return gymService.getGymById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void createGym(@RequestBody GymDto gymDto) {
        gymService.createGym(gymDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public void updateGym(@RequestBody GymDto gymDto, @PathVariable Long id){
        gymService.updateGym(gymDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteGym(@PathVariable Long id){
        gymService.deleteGymById(id);
    }

    @PostMapping("/addMember")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void addMember(@PathParam("userId") Long userId, @PathParam("gymId") Long gymId) {
        gymService.addMember(userId, gymId);
    }

    @DeleteMapping("/deleteMember")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMember(@PathParam("userId") Long userId, @PathParam("gymId") Long gymId) {
        gymService.deleteMember(userId, gymId);
    }

}
