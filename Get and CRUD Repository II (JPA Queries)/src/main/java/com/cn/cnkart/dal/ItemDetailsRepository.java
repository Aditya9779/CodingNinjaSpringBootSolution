package com.cn.cnkart.dal;

import com.cn.cnkart.entity.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//This Integer for the ID (Type if its is long =Long etc)
public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Integer> {
    //Derived Queries
    //In this method we have to find the price greater that what ever we send the price
    List<ItemDetails> findByPriceGreaterThan(double price);

    //JPQL Queries  (=?1 this is known as positional parameter)
    @Query("Select itd from ItemDetails itd where itd.category=?1 ORDER BY itd.price DESC")
    List<ItemDetails> findByCategoryOrderByPrice(String category);
    //OR
    /*For this their is one more similiar method is their*/
    //Name Native is their but its is entity level (see in the ItemDeatils.class)





    //If we want to pass the one more parameters so we do like that
   /* @Query("Select itd from ItemDetails itd where itd.category=?1 and itd.brand=?2 ORDER BY itd.price DESC")
    List<ItemDetails> findByCategoryAndBrandOrderByPrice(String category, String brand);*/


}
