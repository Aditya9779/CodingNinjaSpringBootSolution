package org.cn.cnkart.Controller;

import org.cn.cnkart.Entity.Item;
import org.cn.cnkart.Entity.Order;
import org.cn.cnkart.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/id/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrderInDb(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrderInDb(id);
    }

    @PutMapping("/update")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrderInDb(order);
    }
}
