package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventScheduleDetailDAL;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventScheduleDetailService {

	@Autowired
	EventScheduleDetailDAL eventScheduleDetailDAL;

	@Transactional
	public EventScheduleDetail getEventScheduleDetailById(Long id) {
		EventScheduleDetail eventScheduleDetail= eventScheduleDetailDAL.getById(id);

		if(eventScheduleDetail==null)
		{
			throw new NotFoundException("No EventScheduleDetail found with id:  "+id);
		}
		return eventScheduleDetail;
	}

	@Transactional
	public List<EventScheduleDetail> getAllEventScheduleDetails() {
		List<EventScheduleDetail> eventScheduleDetails= eventScheduleDetailDAL.getAllEventScheduleDetails();
		if(eventScheduleDetails==null){

			throw new NotFoundException("No eventScheduleDetail found");
		}
		return eventScheduleDetails;
	}

	@Transactional
	public String saveEventScheduleDetail(EventScheduleDetail newEventScheduleDetail) {
		List<EventScheduleDetail> allEventScheduleDetails = getAllEventScheduleDetails();
		for(EventScheduleDetail eventScheduleDetail : allEventScheduleDetails)
		{
			if(eventScheduleDetail.getId()==newEventScheduleDetail.getId())
			{
				throw new ElementAlreadyExistException("This eventScheduleDetail already exist.");
			}
		}
		try {
			return eventScheduleDetailDAL.save(newEventScheduleDetail);
		}
		catch (Exception e)
		{
			throw new InvalidInputException("The input entity for eventScheduleDetail is invalid.");
		}
	}
}
