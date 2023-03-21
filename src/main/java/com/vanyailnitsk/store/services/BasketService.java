package com.vanyailnitsk.store.services;

import com.vanyailnitsk.store.models.Basket;
import com.vanyailnitsk.store.models.Device;
import com.vanyailnitsk.store.repositories.BasketRepository;
import com.vanyailnitsk.store.repositories.DeviceRepository;
import com.vanyailnitsk.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
public class BasketService {
    private final BasketRepository basketRepository;
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;

    @Autowired
    public BasketService(BasketRepository basketRepository,
                         DeviceRepository deviceRepository,
                         UserRepository userRepository) {
        this.basketRepository = basketRepository;
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
    }

    public Basket getBasket(Integer id) {
        return basketRepository.findById(id).orElseThrow(() -> new IllegalStateException("No basket with id " + id));
    }

    public Basket createBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    public List<Device> getItems(String username)  {
        System.out.println(username);
        List<Device> items = userRepository.findByEmail(username).getBasket().getItems();
        return items;
    }

    @Transactional
    public Basket addItem(String username,Integer deviceId) {
        Basket basket = userRepository.findByEmail(username).getBasket();
        List<Device> items =  basket.getItems();
        items.add(deviceRepository.findById(deviceId).orElseThrow(()->new IllegalStateException("No device with id"+deviceId)));
        return basket;
    }
}
