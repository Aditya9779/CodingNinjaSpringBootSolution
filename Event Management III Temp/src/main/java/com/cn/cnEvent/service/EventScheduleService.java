package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventScheduleDetailsDAL;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventScheduleService {
    @Autowired
    EventScheduleDetailsDAL eventScheduleDetailsDAL;

    /*ESD -- EventScheduleDetails*/
    @Transactional
    public String addEventScheduleDetails(EventScheduleDetail event) {
        List<EventScheduleDetail> allEventScheduleDetail = getAllEventScheduleDetails();
        for (EventScheduleDetail eventScheduleDetail : allEventScheduleDetail) {
            if (eventScheduleDetail.getId() == event.getId()) {
                throw new ElementAlreadyExistException("Already Present");
            }
        }
        try {
            return eventScheduleDetailsDAL.addInDbESD(event);
        } catch (Exception e) {
            throw new InvalidInputException("Not found");
        }
    }

    @Transactional
    public EventScheduleDetail getEventScheduleDetails(Long id) {
        EventScheduleDetail eventScheduleDetail = eventScheduleDetailsDAL.getFromDbESD(id);
        if (eventScheduleDetail == null) {
            throw new NotFoundException("Event schedule detail with ID " + id + " not found.");
        }
        return eventScheduleDetail;
    }

    @Transactional
    public List<EventScheduleDetail> getAllEventScheduleDetails() {
        List<EventScheduleDetail> eventScheduleDetails = eventScheduleDetailsDAL.getFromAllDbESD();
        if (eventScheduleDetails.isEmpty()) {
            throw new NotFoundException("No event schedule details found.");
        }
        return eventScheduleDetails;
    }
}
