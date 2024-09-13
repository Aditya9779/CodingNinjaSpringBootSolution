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
        return itemDal.getItemFromDB(id);
    }
    @Transactional
    public void addItemInDb(Item item) {
        itemDal.addItemDb(item);
    }
    @Transactional
    public void deleteItemInDb(int id) {
        itemDal.deleteItemDb(id);
    }
    @Transactional
    public void updateItemInDb(Item item) {
        itemDal.updateItemDb(item);
    }
}
