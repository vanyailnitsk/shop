package com.vanyailnitsk.store.controllers;

import com.vanyailnitsk.store.models.Device;
import com.vanyailnitsk.store.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/devices/")
public class DeviceController {
    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("{id}")
    public Device getDevice(@PathVariable("id") Integer id) {
        return deviceService.getDevice(id);
    }

    @GetMapping("all")
    public List<Device> getAllDevices() {
        return deviceService.getAll();
    }

    @PostMapping("create")
    public Device createDevice(@RequestBody Device device) {
        return deviceService.createDevice(device);
    }
}
