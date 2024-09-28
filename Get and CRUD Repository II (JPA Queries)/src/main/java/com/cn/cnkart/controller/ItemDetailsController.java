package com.cn.cnkart.controller;

import com.cn.cnkart.entity.ItemDetails;
import com.cn.cnkart.service.ItemDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class ItemDetailsController {

    @Autowired
    ItemDetailsService itemDetailsService;

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable int id) {
        itemDetailsService.delete(id);
    }

    @GetMapping("/item/price/{price}")
    public List<ItemDetails> getItemDetailsByPrice(@PathVariable double price) {
        return itemDetailsService.getItemDetailsByPrice(price);
    }
    @GetMapping("/item/category/{category}")
    public List<ItemDetails> getItemDetailsByCategory(@PathVariable String category){
        return itemDetailsService.getItemDetailsByCategory(category);
    }
}