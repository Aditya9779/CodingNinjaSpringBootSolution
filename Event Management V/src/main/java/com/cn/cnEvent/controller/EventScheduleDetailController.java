package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.service.EventScheduleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/eventScheduleDetail")
public class EventScheduleDetailController {

    @Autowired
    EventScheduleDetailService eventScheduleDetailService;

    @GetMapping("/{id}")
    public EventScheduleDetail getEventScheduleDetailById(@PathVariable Long id)
    {
        return eventScheduleDetailService.getEventScheduleDetailById(id);
    }

    @GetMapping("/all")
    public List<EventScheduleDetail> getAllEventScheduleDetails()
    {
        return eventScheduleDetailService.getAllEventScheduleDetails();
    }

    @PostMapping("/save")
    public  String saveEventScheduleDetail(@RequestBody EventScheduleDetail event)
    {
        return eventScheduleDetailService.saveEventScheduleDetail(event);
    }
}
