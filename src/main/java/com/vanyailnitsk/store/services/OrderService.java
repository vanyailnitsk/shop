package com.vanyailnitsk.store.services;

import com.vanyailnitsk.store.models.Basket;
import com.vanyailnitsk.store.models.Device;
import com.vanyailnitsk.store.models.User;
import com.vanyailnitsk.store.models.order.Order;
import com.vanyailnitsk.store.repositories.BasketRepository;
import com.vanyailnitsk.store.repositories.OrderRepository;
import com.vanyailnitsk.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,UserRepository userRepository,BasketRepository basketRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
    }

    public Order createOrder(String username, List<Device> items) {
        User user = userRepository.findByEmail(username);
        Order order = new Order();
        order.setUser(user);
        order.setItems(items);
        return orderRepository.save(order);
    }
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrders(String username) {
        List<Order> orders = userRepository.findByEmail(username).getOrders();
        return orders;
    }

    @Transactional
    public Order createOrder(String name) {
        User user = userRepository.findByEmail(name);
        Order order = new Order();
        order.setUser(user);
        order.setItems(new ArrayList<>(user.getBasket().getItems()));
        order.setDate(LocalDate.now());
        return orderRepository.save(order);
    }
}
