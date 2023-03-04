package com.vanyailnitsk.store.repositories;

import com.vanyailnitsk.store.models.DeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceInfoRepository extends JpaRepository<DeviceInfo,Integer> {
}
