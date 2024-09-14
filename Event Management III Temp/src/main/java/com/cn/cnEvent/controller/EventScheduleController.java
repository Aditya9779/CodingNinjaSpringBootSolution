package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.service.EventScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventScheduleDetail")
public class EventScheduleController {

    @Autowired
    private EventScheduleService eventScheduleService;

    @PostMapping("/save")
    public String addEventScheduleDetails(@RequestBody EventScheduleDetail event) {
        return eventScheduleService.addEventScheduleDetails(event);
    }

    @GetMapping("/{id}")
    public EventScheduleDetail getEventScheduleDetails(@PathVariable Long id) {
        return eventScheduleService.getEventScheduleDetails(id);
    }

    @GetMapping("/all")
    public List<EventScheduleDetail> getAllEventScheduleDetails() {
        return eventScheduleService.getAllEventScheduleDetails();
    }


}

