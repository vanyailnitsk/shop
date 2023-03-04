package com.vanyailnitsk.store.repositories;

import com.vanyailnitsk.store.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
