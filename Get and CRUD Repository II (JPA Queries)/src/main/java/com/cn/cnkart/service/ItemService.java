package com.cn.cnkart.service;

import com.cn.cnkart.dal.ItemRepository;
import com.cn.cnkart.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item getItemById(int id) {
        return itemRepository.findById(id).get();
    }
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public void delete(int id) {
        itemRepository.delete(getItemById(id));
    }

    public void update(Item updateItem) {
          itemRepository.save(updateItem);
    }

    public List<Item> getItemAll() {
        List<Item> items = new ArrayList<>();
       //itemRepository.findAll().forEach(item -> items.add(item));
        //Or
        for (Item item : itemRepository.findAll()) {
            items.add(item);
        }
        return items;
    }

    public List<Item> getItemByDesc(String desc) {
       return itemRepository.getItemByDesc(desc);
    }
}