package org.cn.cnkart.Service;

import jakarta.transaction.Transactional;
import org.cn.cnkart.Entity.ItemReviews;
import org.cn.cnkart.Repository.ItemReviewDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemReviewService {
    @Autowired
    private ItemReviewDal itemReviewDal;

    public void addItemReview(ItemReviews itemReviews) {
        itemReviewDal.save(itemReviews);

    }
}
