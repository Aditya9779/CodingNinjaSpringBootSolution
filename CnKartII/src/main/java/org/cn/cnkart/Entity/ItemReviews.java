package org.cn.cnkart.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "item_reviews")
public class ItemReviews {
    //Making It bidirectional
    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonBackReference //This is use for not going the loop inside serialization and deserialization
    // in the process while making the code in json format for sending and api and receiving from the api
    //it like item send to (item) class and itemReviews class send to (itemReview) Class.
    private Item item;
    /*********************************************************/
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @Column
    private String reviewerName;
    @Column
    private String review;

    public Item getItem() {
        return item; //This item is mapped by the Item Reviews in Item
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getId() {
        return id;
    }


}
