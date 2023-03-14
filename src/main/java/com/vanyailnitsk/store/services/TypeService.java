package com.vanyailnitsk.store.services;

import com.vanyailnitsk.store.models.Type;
import com.vanyailnitsk.store.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type createType(Type type) {
        return typeRepository.save(type);
    }
    public List<Type> getTypes() {
        return typeRepository.findAll();
    }
    public Type getType(Integer id) {
        return typeRepository.findById(id).orElseThrow(() -> new IllegalStateException("No type with id " +id));
    }
}
