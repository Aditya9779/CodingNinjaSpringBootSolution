package com.cn.cnkart.service;

import com.cn.cnkart.dal.ItemDetailsRepository;
import com.cn.cnkart.dal.ItemRepository;
import com.cn.cnkart.entity.ItemDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemDetailsService {
    @Autowired
    ItemDetailsRepository itemDetailsRepository;


    public void delete(int id) {
        itemDetailsRepository.deleteById(id);
    }


    public List<ItemDetails> getItemDetailsByPrice(double price) {
     return itemDetailsRepository.findByPriceGreaterThan(price);
    }

    public List<ItemDetails> getItemDetailsByCategory(String category) {
       return itemDetailsRepository.findByCategoryOrderByPrice(category);
    }
}