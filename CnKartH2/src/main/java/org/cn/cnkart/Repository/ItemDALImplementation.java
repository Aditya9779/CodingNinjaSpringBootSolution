package org.cn.cnkart.Repository;

import jakarta.persistence.EntityManager;
import org.cn.cnkart.Entity.Item;
import org.cn.cnkart.Exception.ItemNotFoundException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDALImplementation implements ItemDal {
    @Autowired
    private EntityManager entityManager;


    @Override
    public Item getItemFromDB(int id) {
        Session session = entityManager.unwrap(Session.class);
        Item item = session.get(Item.class, id);
        if (item != null) {
            return item;
        } else {
            throw new ItemNotFoundException("Id Not Found");
        }
    }


    @Override
    public void addItemDb(Item item) {
        Session session = entityManager.unwrap(Session.class);
        session.save(item);
    }


    @Override
    public void deleteItemDb(int id) {
        Session session = entityManager.unwrap(Session.class);
        Item item = session.get(Item.class, id);
        if (item != null) {
            session.delete(item);
        } else {
            throw new ItemNotFoundException("Item Not Found To delete");
        }
    }

    @Override
    public void updateItemDb(Item item) {
        Session session = entityManager.unwrap(Session.class);
        //Fetech the data
        Item currentItem = session.get(Item.class, item.getId());
        if (currentItem != null) {
            currentItem.setName(item.getName());
            currentItem.setDescription(item.getDescription());
            session.update(currentItem);
        } else {
            throw new ItemNotFoundException("Item Not Found To update");
        }
    }

}
