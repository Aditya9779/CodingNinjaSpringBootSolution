package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    // API to fetch a speaker by ID
    @GetMapping("/{id}")
    public Speaker getSpeakerById(@PathVariable Long id) {
        return speakerService.getSpeakerById(id);
    }

    // API to fetch all speakers
    @GetMapping("/all")
    public List<Speaker> getAllSpeakers() {
        return speakerService.getAllSpeakers();
    }

    // API to fetch speakers based on event count and experience
    @GetMapping("/eventCount/{eventCount}/experience/{experience}")
    public List<Speaker> getSpeakersByEventCountAndExperience(
            @PathVariable Long eventCount, @PathVariable Long experience) {
        return speakerService.findSpeakersByEventCountAndExperience(eventCount, experience);
    }

    // API to associate a speaker with an event
    @PostMapping("/id/{speakerId}/eventId/{eventId}")
    public String addSpeakerToEvent(@PathVariable("speakerId") Long speakerId,
                                    @PathVariable("eventId") Long eventId) {
        speakerService.addSpeakerToEvent(speakerId, eventId);
        return "Speaker added to event successfully.";
    }

    // API to save a speaker
    @PostMapping("/save")
    public String saveSpeaker(@RequestBody Speaker speaker) {
        speakerService.saveSpeaker(speaker);
        return "The speaker was saved successfully.";
    }
}
