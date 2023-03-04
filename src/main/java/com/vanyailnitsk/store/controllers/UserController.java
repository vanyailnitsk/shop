package com.vanyailnitsk.store.controllers;

import com.vanyailnitsk.store.models.User;
import com.vanyailnitsk.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


}
