package org.cn.cnkart.Service;

import jakarta.transaction.Transactional;
import org.cn.cnkart.Entity.Item;
import org.cn.cnkart.Repository.ItemDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ItemDal itemDal;

    @Transactional
    public Item getItem(int id) {
        return itemDal.findById(id).get();
    }

    @Transactional
    public void addItemInDb(Item item) {
        itemDal.save(item);
    }

    @Transactional
    public void deleteItemInDb(int id) {
        itemDal.delete(getItem(id));
    }

    @Transactional
    public void updateItemInDb(Item item) {
        Item currentItem = getItem(item.getId());
        currentItem.setDescription(item.getDescription());
        currentItem.setOrders(item.getOrders());
        currentItem.setItemDetails(item.getItemDetails());
        currentItem.setItemReviews(item.getItemReviews());
        currentItem.setName(item.getName());
        addItemInDb(currentItem);
    }
}
