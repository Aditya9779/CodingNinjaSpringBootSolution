package com.cn.cnkart.dal;

import com.cn.cnkart.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    //This Is Native Query and in this we do not pass the entity we pass the table
    // name directly so its same as sql query and (:) this is place holder and
    // this is used for passing the value to find in the table
    @Query(value = "SELECT * FROM item WHERE description LIKE :desc% ", nativeQuery = true)
    List<Item> getItemByDesc(@Param("desc") String desc);

    //Or Second method in the entity level in the item class see the up
//    @Query(name = "Item.getItemByDesc", nativeQuery = true)
//    List<Item> getItemByDesc(String desc);

}
