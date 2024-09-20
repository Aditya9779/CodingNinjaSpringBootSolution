package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.EventScheduleDetail;

import java.util.List;

public interface EventScheduleDetailDAL {

	EventScheduleDetail getById(Long id);

	List<EventScheduleDetail> getAllEventScheduleDetails();

	String save(EventScheduleDetail item);
}
