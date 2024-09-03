package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EventDalImp implements EventDAL {
    @Autowired
    EntityManager entityManager;

    @Override
    public Event getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Event.class, id);
    }

    @Override
    public List<Event> getAllEvents() {
        Session session = entityManager.unwrap(Session.class);
        List<Event> details = session.createQuery("from Event ", Event.class).getResultList();
        return details;
    }

    @Override
    public String save(Event item) {
        Session session = entityManager.unwrap(Session.class);
        session.save(item);
        return "The event was saved successfully.";
    }

    @Override
    public void deleteEventDb(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event event = session.get(Event.class, id);
        session.delete(event);
    }

    @Override
    public void updateEvent(Event event) {
        Session session = entityManager.unwrap(Session.class);
        Event currentEvent = session.get(Event.class, event.getId());
        currentEvent.setDescription(event.getDescription());
        currentEvent.setName(event.getName());
        session.update(currentEvent);
    }
}
