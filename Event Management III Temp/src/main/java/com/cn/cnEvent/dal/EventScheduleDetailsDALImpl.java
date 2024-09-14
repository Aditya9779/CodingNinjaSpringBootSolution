package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.EventScheduleDetail;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EventScheduleDetailsDALImpl implements EventScheduleDetailsDAL {
    @Autowired
    EntityManager entityManager;

    @Override
    public String addInDbESD(EventScheduleDetail event) {
        Session session = entityManager.unwrap(Session.class);
        session.save(event);
        return "saved successfully";
    }

    @Override
    public EventScheduleDetail getFromDbESD(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(EventScheduleDetail.class, id);
    }

    @Override
    public List<EventScheduleDetail> getFromAllDbESD() {
        Session session = entityManager.unwrap(Session.class);
        List<EventScheduleDetail> eventScheduleDetail = session.createQuery("SELECT e FROM EventScheduleDetail e", EventScheduleDetail.class).getResultList();
        return eventScheduleDetail;
    }
}
