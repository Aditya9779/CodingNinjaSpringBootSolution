package org.cn.cnkart.Repository;

import org.cn.cnkart.Entity.Order;

public interface OrderDal {
    Order getOrderFromDB(int id);

    void addOrderDb(Order order);

    void deleteOrderDb(int id);

    void updateOrderDb(Order order);
}
