package org.cn.cnkart.Repository;

import org.cn.cnkart.Entity.Item;

public interface ItemDal {
    Item getItemFromDB(int id);

    void addItemDb(Item item);

    void deleteItemDb(int id);

    void updateItemDb(Item item);
}
