// package com.maids.test.service;

// import com.maids.test.Exceptions.DeviceException;
// import com.maids.test.model.Device;
// import com.maids.test.Response.PricePredictionResponse; // Import the new response class
// import com.maids.test.repo.DeviceRepository;

// import jakarta.transaction.Transactional;
// import org.springframework.http.MediaType;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
// import java.util.Optional;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.List;

// @Service
// public class DeviceService {
//     @Autowired
//     private DeviceRepository deviceRepository;

//     @Autowired
//     private RestTemplate restTemplate;

//     public Map<String, Object> convertDeviceToFeatures(Device device) {
//         Map<String, Object> features = new HashMap<>();

//         features.put("battery_power", device.getBatteryPower());
//         features.put("blue", device.isHasBluetooth() ? 1 : 0); // reconverting boolean features to (0,1)
//         features.put("clock_speed", device.getClockSpeed());
//         features.put("dual_sim", device.isHasDualSim() ? 1 : 0);
//         features.put("fc", device.getFrontCamera());
//         features.put("four_g", device.isHas4G() ? 1 : 0);
//         features.put("int_memory", device.getInternalMemory());
//         features.put("m_dep", device.getMobileDepth());
//         features.put("mobile_wt", device.getMobileWeight());
//         features.put("n_cores", device.getNumberOfCores());
//         features.put("pc", device.getPrimaryCamera());
//         features.put("px_height", device.getPixelHeight());
//         features.put("px_width", device.getPixelWidth());
//         features.put("ram", device.getRam());
//         features.put("sc_h", device.getScreenHeight());
//         features.put("sc_w", device.getScreenWidth());
//         features.put("talk_time", device.getTalkTime());
//         features.put("three_g", device.isHas3G() ? 1 : 0);
//         features.put("touch_screen", device.isHasTouchScreen() ? 1 : 0);
//         features.put("wifi", device.isHasWifi() ? 1 : 0);

//         return features;
//     }

//     // Retrieve a list of all devices
//     public List<Device> getAllDevices() {
//         return deviceRepository.findAll();
//     }

//     // Retrieve details of a specific device by ID
//     public Device getDeviceById(Long id) {
//         Optional<Device> device = deviceRepository.findById(id);
//         return device.orElse(null); // Return null or handle not found
//     }

//     // Add a new device
//     @Transactional
//     public Device addDevice(Device device) {
//         // Check if the device ID already exists in the database
//         if (deviceRepository.existsById(device.getId())) {
//             // If the device already exists, throw a custom exception
//             throw new DeviceException("Device with ID " + device.getId() + " already exists.");
//         } else {
//             // If the device does not exist, save and return the new device
//             return deviceRepository.save(device);
//         }
//     }

//     // Call Python API to predict the price
//     @Transactional
//     public Device predictPrice(Long deviceId) {
//         try {
//             Device device = getDeviceById(deviceId);
//             if (device != null) {
//                 if (device.getPredictedPrice() != null) {
//                     // If predicted price is already set, return the device from the database
//                     return device;
//                 }

//                 // // Convert the device to feature map
//                 // Map<String, Object> features = convertDeviceToFeatures(device);

//                 // // Call your Python API endpoint here
//                 // String pythonApiUrl = "http://127.0.0.1:5000/api/predict"; // Replace with your actual Python API URL

//                 // // Set up headers
//                 // HttpHeaders headers = new HttpHeaders();
//                 // headers.setContentType(MediaType.APPLICATION_JSON);

//                 // // Create an HttpEntity with the features and headers
//                 // HttpEntity<Map<String, Object>> entity = new HttpEntity<>(features, headers);

                

//                 // // Use postForObject with the correct method signature
//                 // PricePredictionResponse response = restTemplate.postForObject(pythonApiUrl, entity, PricePredictionResponse.class);

//                 // if (response != null && response.getPredicted_price_range() != null) {
//                 //     device.setPredictedPrice(response.getPredicted_price_range());
//                 //     deviceRepository.save(device); // Save the updated device entity
//                 // }

//                 // Convert the device to feature map
//             Map<String, Object> features = convertDeviceToFeatures(device);

//             // Call your Python API endpoint here
//             String pythonApiUrl = "http://127.0.0.1:5000/api/predict"; // Replace with your actual Python API URL

//             // Set up headers
//             HttpHeaders headers = new HttpHeaders();
//             headers.setContentType(MediaType.APPLICATION_JSON);

//             // Create an HttpEntity with the features and headers
//             HttpEntity<Map<String, Object>> entity = new HttpEntity<>(features, headers);

//             // Log the request for debugging
//             System.out.println("Sending request to Flask API: " + entity.getBody());
//             System.out.println("Calling URL: " + pythonApiUrl);

//             // Use postForObject to call the Flask API
//             PricePredictionResponse response = restTemplate.postForObject(pythonApiUrl, entity, PricePredictionResponse.class);

//             // Log the response
//             if (response != null) {
//                 System.out.println("Received response from Flask API: " + response);
//                 if (response.getPredicted_price_range() != null) {
//                     device.setPredictedPrice(response.getPredicted_price_range());
//                     deviceRepository.save(device); // Save the updated device entity
//                 }
//             } else {
//                 System.out.println("No response received from Flask API.");
//             }
//             }
//             return device; // Return the updated device
//         } catch (Exception e) {
//             // Log the error
//             throw new DeviceException("Error predicting price for device ID " + deviceId + ": " + e.getMessage());
//         }
//     }
// }



















// package com.maids.test.service;

// import com.maids.test.Exceptions.DeviceException;
// import com.maids.test.model.Device;
// import com.maids.test.Response.PricePredictionResponse;
// import com.maids.test.repo.DeviceRepository;

// import jakarta.transaction.Transactional;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.MediaType;
// import org.springframework.stereotype.Service;


// import org.springframework.web.client.RestTemplate;


// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;

// @Service
// public class DeviceService {

//     @Autowired
//     private DeviceRepository deviceRepository;

//     @Autowired
//     private RestTemplate restTemplate;

//     public Map<String, Object> convertDeviceToFeatures(Device device) {
//         Map<String, Object> features = new HashMap<>();
//         features.put("battery_power", device.getBatteryPower());
//         features.put("blue", device.isHasBluetooth() ? 1 : 0);
//         features.put("clock_speed", device.getClockSpeed());
//         features.put("dual_sim", device.isHasDualSim() ? 1 : 0);
//         features.put("fc", device.getFrontCamera());
//         features.put("four_g", device.isHas4G() ? 1 : 0);
//         features.put("int_memory", device.getInternalMemory());
//         features.put("m_dep", device.getMobileDepth());
//         features.put("mobile_wt", device.getMobileWeight());
//         features.put("n_cores", device.getNumberOfCores());
//         features.put("pc", device.getPrimaryCamera());
//         features.put("px_height", device.getPixelHeight());
//         features.put("px_width", device.getPixelWidth());
//         features.put("ram", device.getRam());
//         features.put("sc_h", device.getScreenHeight());
//         features.put("sc_w", device.getScreenWidth());
//         features.put("talk_time", device.getTalkTime());
//         features.put("three_g", device.isHas3G() ? 1 : 0);
//         features.put("touch_screen", device.isHasTouchScreen() ? 1 : 0);
//         features.put("wifi", device.isHasWifi() ? 1 : 0);

//         return features;
//     }

//     // Retrieve a list of all devices
//     public List<Device> getAllDevices() {
//         return deviceRepository.findAll();
//     }

//     // Retrieve details of a specific device by ID
//     public Device getDeviceById(Long id) {
//         Optional<Device> device = deviceRepository.findById(id);
//         return device.orElse(null);
//     }

//     // Add a new device
//     @Transactional
//     public Device addDevice(Device device) {
//         if (deviceRepository.existsById(device.getId())) {
//             throw new DeviceException("Device with ID " + device.getId() + " already exists.");
//         } else {
//             return deviceRepository.save(device);
//         }
//     }

//     // Call Python API to predict the price
//     @Transactional
//     public Device predictPrice(Long deviceId) {
//         try {
//             Device device = getDeviceById(deviceId);
//             if (device != null) {
//                 if (device.getPredictedPrice() != null) {
//                     return device;
//                 }

//                 Map<String, Object> features = convertDeviceToFeatures(device);
//                 String pythonApiUrl = "http://127.0.0.1:5000/api/predict";

//                 HttpHeaders headers = new HttpHeaders();
//                 headers.setContentType(MediaType.APPLICATION_JSON);
//                 HttpEntity<Map<String, Object>> entity = new HttpEntity<>(features, headers);

//                 System.out.println("Sending request to Flask API: " + entity.getBody());
//                 System.out.println("Calling URL: " + pythonApiUrl);

//                 PricePredictionResponse response = restTemplate.postForObject(pythonApiUrl, entity, PricePredictionResponse.class);

//                 if (response != null) {
//                     System.out.println("Received response from Flask API: " + response);
//                     if (response.getPredicted_price_range() != null) {
//                         device.setPredictedPrice(response.getPredicted_price_range());
//                         deviceRepository.save(device);
//                     }
//                 } else {
//                     System.out.println("No response received from Flask API.");
//                 }
//             }
//             return device;
//         } catch (Exception e) {
//             throw new DeviceException("Error predicting price for device ID " + deviceId + ": " + e.getMessage());
//         }
//     }
// }














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










