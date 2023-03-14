package com.vanyailnitsk.store.services;

import com.vanyailnitsk.store.models.Brand;
import com.vanyailnitsk.store.repositories.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }
}
