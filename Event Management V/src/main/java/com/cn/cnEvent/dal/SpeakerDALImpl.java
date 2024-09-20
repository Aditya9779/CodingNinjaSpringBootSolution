package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.service.EventService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SpeakerDALImpl implements SpeakerDAL {

    @Autowired
    EntityManager entityManager;
    @Autowired
    EventService eventService;

    // Get a Speaker by its ID
    @Override
    public Speaker getSpeakerById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Speaker.class, id);
    }

    // Fetch all Speakers
    @Override
    public List<Speaker> getAllSpeakers() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Speaker", Speaker.class).getResultList();
    }

    // Find Speakers by Event Count and Experience
    @Override
    public List<Speaker> findSpeakersByEventCountAndExperience(Long eventCount, Long experience) {
//        List<Event> events = eventService.getAllEvents();
        List<Speaker> toAdd = new ArrayList<>();
        // fetching all the speaker is enough,
        // since it also has mapping with Event,
        // so, we don't need to fetch Events here
        List<Speaker> speakers = getAllSpeakers();
//        for (Event event : events) {
//            List<Speaker> speakers = event.getSpeakers();
            for (Speaker speaker : speakers) {
                if (speaker.getExperience() > experience) {
                    if (speaker.getEvents().size() >= eventCount /*&& !toAdd.contains(speaker)*/) {
                        toAdd.add(speaker);
                    }
                }
            }
//        }
        return toAdd;
    }

    // Save a Speaker
    @Override
    public void saveSpeaker(Speaker speaker) {
        Session session = entityManager.unwrap(Session.class);
        session.save(speaker);
    }

    // Add a Speaker to an Event
    // this method is used to create mapping between Speaker and Event
    // with provided speakerId and eventId
    // so, fetch both entities using their ids
    // and add each other in their lists,
    // and save them finally,
    // that way, a many-to-many mapping will be created between both entities
    @Override
    public void addSpeakerToEvent(Long speakerId, Long eventId) {
//        Event event = eventService.getEventById(eventId);
//        Speaker speaker = getSpeakerById(speakerId);
//        List<Speaker> allSpeakers = getAllSpeakers();
//        allSpeakers.add(speaker);
//        event.setSpeakers(allSpeakers);

        Session session = entityManager.unwrap(Session.class);
        Speaker speaker = session.get(Speaker.class, speakerId);
        Event event = session.get(Event.class, eventId);

        event.getSpeakers().add(speaker);
        speaker.getEvents().add(event);

//        saveSpeaker(speaker);
//        eventService.saveEvent(event);
        session.save(speaker);
        session.save(event);
    }
}
