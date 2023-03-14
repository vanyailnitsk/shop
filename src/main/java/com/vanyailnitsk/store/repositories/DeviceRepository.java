package com.vanyailnitsk.store.repositories;

import com.vanyailnitsk.store.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device,Integer> {
    List<Device> findByTypeUrl(String type_url);
    List<Device> findByBrandId(Integer brandId);
    List<Device> findByTypeId(Integer id);
}
