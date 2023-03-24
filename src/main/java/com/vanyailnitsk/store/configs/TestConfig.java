package com.vanyailnitsk.store.configs;

import com.vanyailnitsk.store.models.*;
import com.vanyailnitsk.store.models.enums.Role;
import com.vanyailnitsk.store.services.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Set;

@Configuration
public class TestConfig {
    private final UserService userService;
    private final DeviceService deviceService;
    private final PasswordEncoder passwordEncoder;
    private final BasketService basketService;

    private final TypeService typeService;
    private final BrandService brandService;

    @Autowired
    public TestConfig(UserService userService, DeviceService deviceService,
                      PasswordEncoder passwordEncoder, BasketService basketService,
                      TypeService typeService,BrandService brandService) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.passwordEncoder = passwordEncoder;
        this.basketService = basketService;
        this.typeService = typeService;
        this.brandService = brandService;
    }


    @Bean
    @Transactional
    CommandLineRunner commandLineRunner() {
        return args -> {
            Type type = typeService.createType(new Type("Смартфоны","smartphones"));
            Type note =  typeService.createType(new Type("Ноутбуки","notebooks"));
            Brand brand = brandService.createBrand(new Brand("Apple"));
            Device device = new Device("Apple iPhone 12", 70000, 7.0, "https://c.dns-shop.ru/thumb/st4/fit/500/500/7f77b0ed61bbdf08a1b879910ed8fe5c/1c2fe53bdea268bdb5cd609848043ef080d0b5285e5062d04e38ba21fe75f251.jpg.webp");
            Device device2 = new Device("Apple iPhone 13", 80000, 9.0, "https://c.dns-shop.ru/thumb/st1/fit/500/500/d2633098e23a4e7f752e174491d547d9/97c5cac2aabbc83a09317e4d7677d6d626118dbf0370881c9229fb2fc494644e.jpg.webp");
            Device device3 = new Device("Apple MacBook Pro 13 2018", 90000, 8.0, "https://irkutsk.vsesrazu.su/goodImage/205128/applemacbook-pro-13-retina-2018touch-bar-mr9v2ru-a-pct-garantiya-rf-silver-138471135-2.jpg");
            Device device4 = new Device("Apple MacBook Pro 14 2021 M1", 120000, 8.0, "https://ipac31.ru/image/cache/data/product/mac/MacBook%20Pro%2014/macbook-pro-14-space-gray-2-700x700.png");
            User user = new User("Ivan", "vanya", passwordEncoder.encode("pass"));
            user.setRoles(Set.of(Role.ROLE_ADMIN,Role.ROLE_USER));
            Basket basket = basketService.createBasket(new Basket());
            device.setBrand(brand);
            device.setType(type);

            device2.setType(type);
            device2.setBrand(brand);

            device3.setType(note);
            device3.setBrand(brand);

            device4.setType(note);
            device4.setBrand(brand);

            basket.setUser(user);
            basket.getItems().add(device);
            deviceService.createDevice(device);
            deviceService.createDevice(device2);
            deviceService.createDevice(device3);
            deviceService.createDevice(device4);
            userService.createUser1(user);
            basketService.createBasket(basket);
            System.out.println(basketService.getBasket(1).getItems());
        };
    }
}
