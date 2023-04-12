package com.vanyailnitsk.store.controllers;

import com.vanyailnitsk.store.models.Basket;
import com.vanyailnitsk.store.models.order.Order;
import com.vanyailnitsk.store.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("all")
    public List<Order> getOrders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return orderService.getOrders(authentication.getName());
    }

    @PostMapping("create")
    public Order createOrder() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return orderService.createOrder(authentication.getName());
    }
}
