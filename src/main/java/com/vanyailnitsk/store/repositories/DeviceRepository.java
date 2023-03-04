package com.vanyailnitsk.store.repositories;

import com.vanyailnitsk.store.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Integer> {
}
