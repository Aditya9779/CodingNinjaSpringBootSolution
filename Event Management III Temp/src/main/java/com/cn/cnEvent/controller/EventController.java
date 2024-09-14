package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
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
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping("/save")
    public String saveEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        return eventService.delete(id);
    }

    @PutMapping("/update")
    public String updateEvent(@RequestBody Event updateEvent) {
        return eventService.update(updateEvent);
    }

    /***************************************************/
    @GetMapping("/eventScheduleDetail/{id}")
    public EventScheduleDetail getEvent_EventScheduleDetail(@PathVariable Long id) {
        return eventService.getEvent_EventScheduleDetail(id);
    }

    @DeleteMapping("/delete/eventScheduleDetail/{id}")
    public String deleteEventchedule(@PathVariable Long id) {
        return eventService.deleteEventchedule(id);
    }

    @GetMapping("/location/{location}")
    public List<Event> getAllEventDetails(@PathVariable String location) {
        return eventService.getAllEventDetailsByLocation(location);
    }

}
