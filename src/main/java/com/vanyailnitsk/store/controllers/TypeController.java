package com.vanyailnitsk.store.controllers;

import com.vanyailnitsk.store.models.Type;
import com.vanyailnitsk.store.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type")
public class TypeController {
    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("")
    public List<Type> getTypes() {
        return typeService.getTypes();
    }

    @PostMapping("")
    public Type createType(@RequestBody Type type) {
        return typeService.createType(type);
    }
}
