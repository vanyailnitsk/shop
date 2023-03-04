package com.vanyailnitsk.store.repositories;

import com.vanyailnitsk.store.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Integer> {
}
