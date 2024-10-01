package org.cn.cnkart.Repository;

import org.cn.cnkart.Entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDal extends CrudRepository<Item,Integer> {

}
