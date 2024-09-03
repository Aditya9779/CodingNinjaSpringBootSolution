package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("/{id}")
    public Event getEventId(@PathVariable Long id) {
        return eventService.getEventId(id);
    }

    @GetMapping("/all")
    public List<Event> getAllEvent() {
        List<Event> details = eventService.getAllEvent();
        return details;
    }

    @PostMapping("/save")
    public void addEvent(@RequestBody Event event) {
        eventService.save(event);
    }

    @DeleteMapping("/delete/{id}")
    public void removeEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
    @PutMapping("/update")
    public void updateEvent(@RequestBody Event event){
        eventService.updateEvent(event);
    }

}
