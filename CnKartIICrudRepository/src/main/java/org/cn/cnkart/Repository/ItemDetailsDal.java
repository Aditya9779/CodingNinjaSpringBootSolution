package org.cn.cnkart.Repository;

import org.cn.cnkart.Entity.Item;
import org.cn.cnkart.Entity.ItemDetails;
import org.springframework.data.repository.CrudRepository;

public interface ItemDetailsDal extends CrudRepository<ItemDetails,Integer> {

}
