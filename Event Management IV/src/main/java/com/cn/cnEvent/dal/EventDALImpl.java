package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.NotFoundException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDALImpl implements EventDAL {

	@Autowired
	EntityManager entityManager;

	@Override
	public Event getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		return event;
	}

	@Override
	public List<Event> getAllEvents() {
		Session session = entityManager.unwrap(Session.class);
		List<Event> allEvents= session.createQuery(
				"SELECT e FROM Event e", Event.class).getResultList();
		return allEvents;
	}

	@Override
	public List<Event> getAllEventsByLocation(String location) {
		List<Event> allEvents = getAllEvents();

		List<Event> eventsByLocation = new ArrayList<>();
		try {
			for (Event event : allEvents) {
				if (event.getEventScheduleDetail().getLocation().equalsIgnoreCase(location)) {
					eventsByLocation.add(event);
				}
			}
		} catch (Exception e) {
			throw new NotFoundException("ScheduleDetail of a event is not present");
		}
		return eventsByLocation;
	}

	@Override
	public EventScheduleDetail getEventScheduleDetailByEventId(Long id){
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		return event.getEventScheduleDetail();
	}

	@Override
	public List<Ticket> getAllTicketsOfEvent(Long id){
		Event event = getById(id);
		return event.getTickets();
	}

	@Override
	public List<Event> getAllEventsHavingTicketPriceGreaterThan(Long price){
		List<Event> allEvents=getAllEvents();
		List<Event> eventsByPrice = new ArrayList<>();
		try {
			for (Event event : allEvents) {
				for (Ticket ticket : event.getTickets()) {
					if (ticket.getPrice() > price) {
						eventsByPrice.add(event);
						break;
					}
				}
			}
		}
		 catch (Exception e) {
			throw new NotFoundException("Tickets not present for the event");
		}
		return eventsByPrice;
	}

	@Override
	public String save(Event event) {
		Session session = entityManager.unwrap(Session.class);
		session.save(event);
		return "The event was saved successfully.";
	}

	@Override
	public String delete(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		session.delete(event);
		return "The event was deleted successfully";
	}

	@Override
	public String deleteEventScheduleDetail(Long id) {
		Session session = entityManager.unwrap(Session.class);
		try {
			EventScheduleDetail eventScheduleDetail = session.createQuery(
							"SELECT e FROM EventScheduleDetail e WHERE e.id = :id", EventScheduleDetail.class)
					.setParameter("id", id)
					.getSingleResult();

			for (Event event : getAllEvents()) {
				if(event.getEventScheduleDetail()!=null && event.getEventScheduleDetail().getId().equals(id)){
					event.setEventScheduleDetail(null);
					save(event);
				}
			}
			session.delete(eventScheduleDetail);
			return "The eventSchedule was deleted successfully";
		} catch (NoResultException ex) {
			return "EventScheduleDetail with id " + id + " does not exist";
		}
	}
	@Override
	public String update(Event updateEvent) {
		Session session = entityManager.unwrap(Session.class);
		Event currentEvent = session.get(Event.class, updateEvent.getId());
		currentEvent.setName(updateEvent.getName());
		currentEvent.setDescription(updateEvent.getDescription());
		session.update(currentEvent);
		return "Event is updated successfully";
	}

}
