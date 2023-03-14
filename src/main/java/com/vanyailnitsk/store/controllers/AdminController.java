package com.vanyailnitsk.store.controllers;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @GetMapping("")
    public String getHello() {
        return "Hello, Admin!";
    }
}
