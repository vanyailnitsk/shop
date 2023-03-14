package com.vanyailnitsk.store.services;

import com.vanyailnitsk.store.models.Device;
import com.vanyailnitsk.store.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device getDevice(Integer id) {
        return deviceRepository.findById(id).orElseThrow(() -> new IllegalStateException("No device with id  " + id));
    }

    public List<Device> getAll() {
        return deviceRepository.findAll();
    }

    public List<Device> getAllByBrand(Integer brandId) {
        return deviceRepository.findByBrandId(brandId);
    }

    public List<Device> getAllByTypeUrl(String typeUrl) {
        return deviceRepository.findByTypeUrl(typeUrl);
    }


    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }
}
