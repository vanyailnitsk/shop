package com.vanyailnitsk.store.repositories;

import com.vanyailnitsk.store.models.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
