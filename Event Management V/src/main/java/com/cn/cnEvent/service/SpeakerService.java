package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.SpeakerDAL;
import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpeakerService {

    @Autowired
    private SpeakerDAL speakerDAL;
    @Autowired
    private EventService eventService;

    // Fetch a Speaker by ID
    @Transactional
    public Speaker getSpeakerById(Long id) {
        Speaker speaker = speakerDAL.getSpeakerById(id);
        if (speaker == null) {
            throw new NotFoundException("Speaker with ID " + id + " not found.");
        }
        return speaker;
    }

    // Fetch all Speakers
    @Transactional
    public List<Speaker> getAllSpeakers() {
        List<Speaker> speaker = speakerDAL.getAllSpeakers();
//        if (speaker.isEmpty()) {
        if (speaker == null) {
            throw new NotFoundException("Not Found");
        }
        return speaker;
    }

    // Fetch Speakers by Event Count and Experience
    @Transactional
    public List<Speaker> findSpeakersByEventCountAndExperience(Long eventCount, Long experience) {
        List<Speaker> speakers = speakerDAL.findSpeakersByEventCountAndExperience(eventCount, experience);
//        if (speakers.isEmpty()) {
//            throw new NotFoundException("No speakers found matching the event count and experience.");
//        }
        return speakers;
    }

    // Save a Speaker
    @Transactional
    public void saveSpeaker(Speaker speaker) {
//        Speaker speaker1 = getSpeakerById(speaker.getId());
        // getSpeakerById will throw NotFoundException, if Speaker with id is not found,
        // so we won't be able to save new Speaker, if we use getSpeakerById method here
        Speaker speaker1 = speakerDAL.getSpeakerById(speaker.getId());
        if (speaker1 == null) {
            speakerDAL.saveSpeaker(speaker);
        } else {
            throw new ElementAlreadyExistException("Already Their");
        }
    }

    // Add a Speaker to an
    @Transactional
    public void addSpeakerToEvent(Long speakerId, Long eventId) {
//        Speaker speaker = speakerDAL.getSpeakerById(speakerId);
//        if (speaker == null) {
//            throw new NotFoundException("Speaker with ID " + speakerId + " not found.");
//        }
//
//        Event event = eventService.getEventById(eventId);
//        if (event == null) {
//            throw new NotFoundException("Event with ID " + eventId + " not found.");
//        }
        speakerDAL.addSpeakerToEvent(speakerId, eventId);
    }

}
