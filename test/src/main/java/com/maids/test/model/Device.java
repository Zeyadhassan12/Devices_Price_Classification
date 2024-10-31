package com.maids.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int batteryPower;
    private boolean hasBluetooth;
    private double clockSpeed;
    private boolean hasDualSim;
    private double frontCamera;
    private boolean has4G;
    private int internalMemory;
    private double mobileDepth;
    private double mobileWeight;
    private int numberOfCores;
    private double primaryCamera;
    private int pixelHeight;
    private int pixelWidth;
    private int ram;
    private double screenHeight;
    private double screenWidth;
    private int talkTime;
    private boolean has3G;
    private boolean hasTouchScreen;
    private boolean hasWifi;


    // Field to store the predicted price range
    private Integer predictedPrice;

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public boolean isHasBluetooth() {
        return hasBluetooth;
    }

    public void setHasBluetooth(boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public boolean isHasDualSim() {
        return hasDualSim;
    }

    public void setHasDualSim(boolean hasDualSim) {
        this.hasDualSim = hasDualSim;
    }

    public double getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(double frontCamera) {
        this.frontCamera = frontCamera;
    }

    public boolean isHas4G() {
        return has4G;
    }

    public void setHas4G(boolean has4G) {
        this.has4G = has4G;
    }

    public int getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(int internalMemory) {
        this.internalMemory = internalMemory;
    }

    public double getMobileDepth() {
        return mobileDepth;
    }

    public void setMobileDepth(double mobileDepth) {
        this.mobileDepth = mobileDepth;
    }

    public double getMobileWeight() {
        return mobileWeight;
    }

    public void setMobileWeight(double mobileWeight) {
        this.mobileWeight = mobileWeight;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public double getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(double primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public int getPixelHeight() {
        return pixelHeight;
    }

    public void setPixelHeight(int pixelHeight) {
        this.pixelHeight = pixelHeight;
    }

    public int getPixelWidth() {
        return pixelWidth;
    }

    public void setPixelWidth(int pixelWidth) {
        this.pixelWidth = pixelWidth;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(double screenHeight) {
        this.screenHeight = screenHeight;
    }

    public double getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(double screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public boolean isHas3G() {
        return has3G;
    }

    public void setHas3G(boolean has3G) {
        this.has3G = has3G;
    }

    public boolean isHasTouchScreen() {
        return hasTouchScreen;
    }

    public void setHasTouchScreen(boolean hasTouchScreen) {
        this.hasTouchScreen = hasTouchScreen;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }



    public Integer getPredictedPrice() {
        return predictedPrice;
    }

    public void setPredictedPrice(Integer predictedPrice) {
        this.predictedPrice = predictedPrice;
    }


    
    
    
}
