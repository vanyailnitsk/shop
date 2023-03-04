package com.vanyailnitsk.store.controllers;

import com.vanyailnitsk.store.models.Basket;
import com.vanyailnitsk.store.models.Device;
import com.vanyailnitsk.store.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/basket/")
public class BasketController {
    private final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("")
    public Basket addItem(@RequestParam(name = "basket") Integer basketId, @RequestParam(name = "device") Integer deviceId) {
        return basketService.addItem(basketId,deviceId);
    }

    @GetMapping("items")
    public List<Device> getItems(Principal principal) {
        return basketService.getItems(principal);
    }
}
