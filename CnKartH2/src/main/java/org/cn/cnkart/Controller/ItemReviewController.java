package org.cn.cnkart.Controller;

import org.cn.cnkart.Entity.ItemReviews;
import org.cn.cnkart.Service.ItemReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ItemReviewController {
    @Autowired
    private ItemReviewService itemReviewService;

    @PostMapping("/save")
    public void addReview(@RequestBody ItemReviews itemReviews) {
        itemReviewService.addItemReview(itemReviews);
    }
}
