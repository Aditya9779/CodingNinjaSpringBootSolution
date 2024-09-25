package com.cn.cnkart.controller;

import com.cn.cnkart.entity.Item;
import com.cn.cnkart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/id/{id}")
    public Item getItemById(@PathVariable int id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/all")
    public List<Item> getAllItem() {
        List<Item> items = itemService.getItemAll();
        return items;
    }


    @PostMapping("/save")
    public void saveItem(@RequestBody Item item) {
        itemService.saveItem(item);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.delete(id);
    }

    @PutMapping("/update")
    public void updateItem(@RequestBody Item updateItem) {
        itemService.update(updateItem);
    }

}