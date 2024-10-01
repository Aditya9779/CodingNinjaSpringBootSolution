package org.cn.cnkart.Repository;

import org.cn.cnkart.Entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDal extends CrudRepository<Order, Integer> {

}
