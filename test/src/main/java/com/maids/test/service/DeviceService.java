

package com.maids.test.service;

import com.maids.test.Exceptions.DeviceException;
import com.maids.test.model.Device;
import com.maids.test.Response.PricePredictionResponse;
import com.maids.test.repo.DeviceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private RestTemplate restTemplate;

    // Read the Python API URL from application.properties
    @Value("${python.api.url}")
    private String pythonApiUrl;

    public Map<String, Object> convertDeviceToFeatures(Device device) {
        Map<String, Object> features = new HashMap<>();
        features.put("battery_power", device.getBatteryPower());
        features.put("blue", device.isHasBluetooth() ? 1 : 0);
        features.put("clock_speed", device.getClockSpeed());
        features.put("dual_sim", device.isHasDualSim() ? 1 : 0);
        features.put("fc", device.getFrontCamera());
        features.put("four_g", device.isHas4G() ? 1 : 0);
        features.put("int_memory", device.getInternalMemory());
        features.put("m_dep", device.getMobileDepth());
        features.put("mobile_wt", device.getMobileWeight());
        features.put("n_cores", device.getNumberOfCores());
        features.put("pc", device.getPrimaryCamera());
        features.put("px_height", device.getPixelHeight());
        features.put("px_width", device.getPixelWidth());
        features.put("ram", device.getRam());
        features.put("sc_h", device.getScreenHeight());
        features.put("sc_w", device.getScreenWidth());
        features.put("talk_time", device.getTalkTime());
        features.put("three_g", device.isHas3G() ? 1 : 0);
        features.put("touch_screen", device.isHasTouchScreen() ? 1 : 0);
        features.put("wifi", device.isHasWifi() ? 1 : 0);

        return features;
    }

    // Retrieve a list of all devices
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    // Retrieve details of a specific device by ID
    public Device getDeviceById(Long id) {
        Optional<Device> device = deviceRepository.findById(id);
        return device.orElse(null);
    }

    // Add a new device
    @Transactional
    public Device addDevice(Device device) {
        if (deviceRepository.existsById(device.getId())) {
            throw new DeviceException("Device with ID " + device.getId() + " already exists.");
        } else {
            return deviceRepository.save(device);
        }
    }

    // Call Python API to predict the price
    @Transactional
    public Device predictPrice(Long deviceId) {
        try {
            Device device = getDeviceById(deviceId);
            if (device != null) {
                // if (device.getPredictedPrice() != null) {
                //     return device;
                // }

                Map<String, Object> features = convertDeviceToFeatures(device);
                
                // Use the URL read from properties
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<Map<String, Object>> entity = new HttpEntity<>(features, headers);
                
                System.out.println("Sending request to Flask API: " + entity.getBody());
                System.out.println("Calling URL: " + pythonApiUrl);

                PricePredictionResponse response = restTemplate.postForObject(pythonApiUrl, entity, PricePredictionResponse.class);

                if (response != null) {
                    System.out.println("Received response from Flask API: " + response);
                    if (response.getPredicted_price_range() != null) {
                        device.setPredictedPrice(response.getPredicted_price_range());
                        deviceRepository.save(device);
                    }
                } else {
                    System.out.println("No response received from Flask API.");
                }
            }
            return device;
        } catch (Exception e) {
            throw new DeviceException("Error predicting price for device ID " + deviceId + ": " + e.getMessage());
        }
    }
}










