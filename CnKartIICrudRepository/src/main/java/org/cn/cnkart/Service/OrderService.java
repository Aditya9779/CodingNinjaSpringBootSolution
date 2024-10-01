package org.cn.cnkart.Service;

import jakarta.transaction.Transactional;
import org.cn.cnkart.Entity.Item;
import org.cn.cnkart.Entity.Order;
import org.cn.cnkart.Repository.ItemDal;
import org.cn.cnkart.Repository.OrderDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderDal orderDal;

    @Autowired
    ItemDal itemDal;

    public Order getOrder(int id) {
        return orderDal.findById(id).get();
    }

    //In this order we are getting the order with the different item
    // so we have to take the items from the order in the item list to save it
    public void addOrderInDb(Order order) {
        Order saveOrder = new Order();
        saveOrder.setOrderType(order.getOrderType());
        //For saveing the list of itemlist of the order type
        List<Item> itemsList = new ArrayList<>();
        //add all the item which is present in the order.getitem list
        for (Item item : order.getItems()) {
            //taking the every item present in the order so add in our currecnt list
            //for getting the item we autowired the itemDal layer to get the item by
            // the item id.
            Item currentItem = itemDal.findById(item.getId()).get();
            itemsList.add(currentItem);
        }
        saveOrder.setItems(itemsList);
        orderDal.save(saveOrder);

    }
//    @Transactional
//    public void saveOrder(Order order) {
//
//        Order saveOrder =new Order();
//        saveOrder.setOrderType(order.getOrderType());
//
//        List<Item> itemList = new ArrayList<>();
//        for(Item item:order.getItems())
//        {
//            Item currentItem=itemDal.getItemFromDB(item.getId());
//            itemList.add(currentItem);
//        }
//        saveOrder.setItems(itemList);
//
//        orderDal.addOrderDb(saveOrder);
//    }

    public void deleteOrderInDb(int id) {
        orderDal.delete(orderDal.findById(id).get());

    }

    public void updateOrderInDb(Order order) {
        orderDal.save(order);
    }
}
