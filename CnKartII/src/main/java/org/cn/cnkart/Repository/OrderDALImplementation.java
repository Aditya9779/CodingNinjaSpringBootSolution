package org.cn.cnkart.Repository;

import jakarta.persistence.EntityManager;
import org.cn.cnkart.Entity.Order;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDALImplementation implements OrderDal {
    @Autowired
    EntityManager entityManager;

    @Override
    public Order getOrderFromDB(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Order.class, id);
    }

    @Override
    public void addOrderDb(Order order) {
        Session session = entityManager.unwrap(Session.class);
        session.save(order);
    }

    @Override
    public void deleteOrderDb(int id) {
        Session session = entityManager.unwrap(Session.class);
        Order order = session.get(Order.class, id);
        session.delete(order);
    }

    @Override
    public void updateOrderDb(Order order) {
        Session session = entityManager.unwrap(Session.class);
        session.update(order);
    }
}
