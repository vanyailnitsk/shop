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

    public List<Device> getItems(Principal principal)  {
        List<Device> items = userRepository.findByEmail(principal.getName()).getBasket().getItems();
        return items;
    }

    @Transactional
    public Basket addItem(Integer basketId,Integer deviceId) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(()-> new IllegalStateException("No basket with  id "+basketId));
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(()->new IllegalStateException("No device with id "+deviceId));
        basket.addItem(device);
        return basketRepository.save(basket);
    }
}
