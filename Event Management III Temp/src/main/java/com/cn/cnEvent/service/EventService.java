package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class EventService {

    @Autowired
    EventDAL eventDAL;

    @Transactional
    public Event getEventById(Long id) {
        return null;
    }

    @Transactional
    public List<Event> getAllEvents() {
        List<Event> events = eventDAL.getAllEvents();
        if (events == null) {

            throw new NotFoundException("No events found.");
        }
        return events;
    }

    @Transactional
    public String saveEvent(Event newEvent) {

        List<Event> allEvents = getAllEvents();
        for (Event event : allEvents) {
            if (Objects.equals(event.getId(), newEvent.getId())) {
                throw new ElementAlreadyExistException("This event already exist.");
            }
        }
        try {
            return eventDAL.save(newEvent);
        } catch (Exception e) {
            throw new InvalidInputException("The input entity for event is invalid.");
        }
    }

    @Transactional
    public String delete(Long id) {
        List<Event> allEvents = getAllEvents();

        boolean isEntityPresent = false;
        for (Event event : allEvents) {
            if (Objects.equals(event.getId(), id)) {
                isEntityPresent = true;
            }
        }
        if (!isEntityPresent) {
            throw new InvalidInputException("This event doesn't exist.");
        }
        try {
            return eventDAL.delete(id);
        } catch (Exception e) {
            throw new InvalidInputException("Error in deleting event.");
        }
    }

    @Transactional
    public String update(Event updateEvent) {
        try {
            return eventDAL.update(updateEvent);
        } catch (Exception e) {
            throw new InvalidInputException("Error in deleting eventScheduleDetail from event.");
        }
    }

    @Transactional
    public EventScheduleDetail getEvent_EventScheduleDetail(Long id) {
        EventScheduleDetail eventScheduleDetail = eventDAL.getEvent_EventScheduleDetail(id);
        if (eventScheduleDetail != null) {
            return eventScheduleDetail;
        }
        throw new NotFoundException("Not Found");
    }

    @Transactional
    public String deleteEventchedule(Long id) {
        return eventDAL.deleteEventSchedule(id);
    }

    @Transactional
    public List<Event> getAllEventDetailsByLocation(String location) {
      /*  List<Event> allEvents = eventDAL.getAllEvents();
        List<EventScheduleDetail> addDetails = new ArrayList<>();
        for (Event event : allEvents) {
            EventScheduleDetail EventDetail = event.getEventScheduleDetail();
            if (EventDetail != null && location.equalsIgnoreCase(EventDetail.getLocation())) {
                addDetails.add(EventDetail);
            }
        }
        return addDetails;*/
        List<Event> eventsAllLocations = eventDAL.getAllEventDetailsByLocation(location);
        if (eventsAllLocations != null) {
            return eventsAllLocations;
        }
        throw new NotFoundException("Not Found");
    }
}
