package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EventService {
    @Autowired
    EventDAL eventDAL;

    public Event getEventId(Long id) {
        return eventDAL.getById(id);
    }

    public List<Event> getAllEvent() {
        List<Event> details = eventDAL.getAllEvents();
        return details;
    }

    public void save(Event event) {
        eventDAL.save(event);
    }

    public void deleteEvent(Long id) {
        eventDAL.deleteEventDb(id);
    }

    public void updateEvent(Event event) {
        eventDAL.updateEvent(event);
    }
}
