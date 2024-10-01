package org.cn.cnkart.Repository;

import org.cn.cnkart.Entity.Item;
import org.cn.cnkart.Entity.ItemReviews;
import org.springframework.data.repository.CrudRepository;

public interface ItemReviewDal extends CrudRepository<ItemReviews,Integer> {

}
