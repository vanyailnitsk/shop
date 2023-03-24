package com.vanyailnitsk.store.services;

import com.vanyailnitsk.store.models.Basket;
import com.vanyailnitsk.store.models.User;
import com.vanyailnitsk.store.models.enums.Role;
import com.vanyailnitsk.store.repositories.BasketRepository;
import com.vanyailnitsk.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,BasketRepository basketRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException("No user with id " + id));
    }

    @Transactional
    public User createUser(User user) {
        Basket basket = new Basket();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        user.setBasket(basket);
        basket.setUser(user);
        basketRepository.save(basket);
        return userRepository.save(user);
    }
    @Transactional
    public User createUser1(User user) {
        Basket basket = new Basket();
        return userRepository.save(user);
    }
}
