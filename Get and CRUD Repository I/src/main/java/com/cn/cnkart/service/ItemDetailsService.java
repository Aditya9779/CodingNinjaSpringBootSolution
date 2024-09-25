package com.cn.cnkart.service;

import com.cn.cnkart.dal.ItemDetailsRepository;
import com.cn.cnkart.dal.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemDetailsService {
    @Autowired
    ItemDetailsRepository itemDetailsRepository;


    public void delete(int id) {
        itemDetailsRepository.deleteById(id);
    }


}