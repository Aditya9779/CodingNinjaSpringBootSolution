package org.cn.cnkart.Repository;

import jakarta.persistence.EntityManager;
import org.cn.cnkart.Entity.ItemDetails;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDetailsDALImplementation implements ItemDetailsDal {
    @Autowired
    EntityManager entityManager;

    @Override
    public void removeDetailsDb(int id) {
        Session session = entityManager.unwrap(Session.class);
        ItemDetails itemDetails = session.get(ItemDetails.class, id);
        session.delete(itemDetails);
    }
}
