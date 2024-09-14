package org.cn.cnkart.Repository;

import jakarta.persistence.EntityManager;
import org.cn.cnkart.Entity.ItemReviews;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemReviewDALImplementation implements ItemReviewDal {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void addInReviewDb(ItemReviews itemReviews) {
        Session session = entityManager.unwrap(Session.class);
        session.save(itemReviews);
    }
}
