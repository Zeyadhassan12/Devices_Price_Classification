package com.maids.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;


import com.maids.test.model.Device;
import jakarta.annotation.PostConstruct;
import java.util.List;
import com.maids.test.repo.DeviceRepository;
import java.io.FileReader;
import java.util.ArrayList;
@Component
public class Loader {

    @Autowired

    private DeviceRepository deviceRepository;
    // Path to your CSV file
    private static final String CSV_FILE_PATH = "src/main/resources/testPredictedPrice.csv";

    @PostConstruct

    public void loadDeviceData() {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
            List<Device> devices = new ArrayList<>();
            String[] line;

            // Skip the header line
            reader.readNext();

            while ((line = reader.readNext()) != null) {
                Device device = new Device();

                // Assuming the first column in the CSV is the ID
                device.setId(Long.parseLong(line[0]));
                device.setBatteryPower(Integer.parseInt(line[1]));
                device.setHasBluetooth(Integer.parseInt(line[2]) == 1); // Converting (0,1) features to boolean
                device.setClockSpeed(Double.parseDouble(line[3]));
                device.setHasDualSim(Integer.parseInt(line[4]) == 1);
                device.setFrontCamera(Double.parseDouble(line[5]));
                device.setHas4G(Integer.parseInt(line[6]) == 1);
                device.setInternalMemory(Integer.parseInt(line[7]));
                device.setMobileDepth(Double.parseDouble(line[8]));
                device.setMobileWeight(Double.parseDouble(line[9]));
                device.setNumberOfCores(Integer.parseInt(line[10]));
                device.setPrimaryCamera(Double.parseDouble(line[11]));
                device.setPixelHeight(Integer.parseInt(line[12]));
                device.setPixelWidth(Integer.parseInt(line[13]));
                device.setRam(Integer.parseInt(line[14]));
                device.setScreenHeight(Double.parseDouble(line[15]));
                device.setScreenWidth(Double.parseDouble(line[16]));
                device.setTalkTime(Integer.parseInt(line[17]));
                device.setHas3G(Integer.parseInt(line[18]) == 1);
                device.setHasTouchScreen(Integer.parseInt(line[19]) == 1);
                device.setHasWifi(Integer.parseInt(line[20]) == 1);


                // Initially set predicted price as null
                device.setPredictedPrice(null);

                // Check if the device already exists in the database
                if (!deviceRepository.existsById(device.getId())) {
                    devices.add(device); // Add only if it does not exist
                } else {
                    //  log or print a message
                    System.out.println("Device with ID " + device.getId() + " already exists. Skipping save.");
                }

        
            }


            // Save all new devices to the repository
            deviceRepository.saveAll(devices);
        
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    

    }

}
