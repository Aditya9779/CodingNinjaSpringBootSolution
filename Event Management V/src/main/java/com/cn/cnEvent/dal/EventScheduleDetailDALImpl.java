package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.EventScheduleDetail;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EventScheduleDetailDALImpl implements EventScheduleDetailDAL {

	@Autowired
	EntityManager entityManager;

	@Override
	public EventScheduleDetail getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		EventScheduleDetail eventScheduleDetail = session.get(EventScheduleDetail.class, id);
		return eventScheduleDetail;
	}

	@Override
	public List<EventScheduleDetail> getAllEventScheduleDetails() {
		Session session = entityManager.unwrap(Session.class);
		List<EventScheduleDetail> allEventScheduleDetails= session.createQuery(
				"SELECT e FROM EventScheduleDetail e", EventScheduleDetail.class).getResultList();
		return allEventScheduleDetails;
	}

	@Override
	public String save(EventScheduleDetail eventScheduleDetail) {
		Session session = entityManager.unwrap(Session.class);
		session.save(eventScheduleDetail);
		return "The eventScheduleDetail was saved successfully.";
	}
}
