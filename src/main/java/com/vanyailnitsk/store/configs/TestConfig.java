package com.vanyailnitsk.store.configs;

import com.vanyailnitsk.store.models.Basket;
import com.vanyailnitsk.store.models.Device;
import com.vanyailnitsk.store.models.User;
import com.vanyailnitsk.store.services.BasketService;
import com.vanyailnitsk.store.services.DeviceService;
import com.vanyailnitsk.store.services.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Configuration
public class TestConfig {
    private final UserService userService;
    private final DeviceService deviceService;
    private final PasswordEncoder passwordEncoder;
    private final BasketService basketService;

    @Autowired
    public TestConfig(UserService userService, DeviceService deviceService,
                      PasswordEncoder passwordEncoder, BasketService basketService) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.passwordEncoder = passwordEncoder;
        this.basketService = basketService;
    }


    @Bean
    @Transactional
    CommandLineRunner commandLineRunner() {
        return args -> {
            Device device = new Device("Iphone 12", 80000, 0.0, "", 1, 2);
            User user = new User("Ivan", "vanya", passwordEncoder.encode("pass"));
            Basket basket = basketService.createBasket(new Basket(1,new ArrayList<>()));
            basket.setUser(user);
            basket.getItems().add(device);
            //device.setBasket(basket);
            deviceService.createDevice(device);
            userService.createUser1(user);
            basketService.createBasket(basket);
            System.out.println(basketService.getBasket(1).getItems());
        };
    }
}
