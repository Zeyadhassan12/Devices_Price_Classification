package com.maids.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maids.test.model.Device;
import com.maids.test.service.DeviceService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    // Retrieve a device by ID
    @GetMapping("/devices/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);
        if (device == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(device);
    }

    // Retrieve all devices
    @GetMapping("/devices")
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return ResponseEntity.ok(devices);
    }

    // Add a new device
    @PostMapping("/devices")
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device createdDevice = deviceService.addDevice(device);
        return ResponseEntity.ok(createdDevice);
    }


    // Call API to predict the price based on specs
    @PostMapping("/predict/{deviceID}")
    public ResponseEntity<?> predictPrice(@PathVariable Long deviceID) {
        Device updatedDevice = deviceService.predictPrice(deviceID);
        return ResponseEntity.ok(updatedDevice);
    }
}
