# Devices_Price_Classification
### Devices Price Classification System using Python and Spring Boot

## Table of Contents
1. [Description](#description)
2. [Project Structure](#project-structure)
3. [Technologies](#technologies)
4. [Installation Instructions](#installation-instructions)
5. [Start Project](#start-project)
6. [Contact Information](#contact-information)


## Description

The Devices Price Classification System is an AI-driven solution that uses a Random Forest model for predicting mobile device price ranges based on their specifications. The system consists of two core components: a Python-based machine learning project for classification and a Spring Boot application for API management and persistence. This system enables sellers to predict device prices, classifying them as low, medium, high, or very high cost, based on various features such as battery power, RAM, camera quality, and screen size.

## Project Structure

### 1. Python Project (ML Model & API):

Modeling: Utilizes a Random Forest classifier to predict device price ranges from device specifications.
Data Processing: Implements data preparation techniques, including data cleaning and feature engineering, to optimize prediction accuracy.
Exploratory Data Analysis (EDA): Uncovers patterns and correlations in device features through visualizations and commentary, facilitating better feature selection.
Endpoints: Exposes a REST API for predictions, receiving device specs and returning the predicted price range.

### 2.Spring Boot Project (API Management & Persistence):

1. Device Entity: Defines a Device entity representing each device in the database, capturing attributes and storing prediction results.

2. Endpoints:

    POST /api/devices: Adds new device records.
    
    GET /api/devices/{id}: Retrieves specific device details.
    
    POST /api/predict/{deviceId}: Calls the Python API for price prediction based on device specs and stores the prediction.
3. Best Practices: Ensures transaction management and RESTful design for API reliability.



## Technologies 

- Flask (Python)
- Spring Boot (Java)
- scikit-learn (for modeling)
- Pandas (data manipulation)
- Matplotlib (for visualization)
- PostgreSQL Database
- RESTful API architecture


## Installation Instructions

1. Clone the Repository :

    ```Bash
        git clone https://github.com/Zeyadhassan12/Devices_Price_Classification.git
2. Navigate to the Flask_app directory and install the requirements :

    ```bash
        cd Flask_app
        pip install -r requirements.txt
3. Navigate to test directory (SpringBoot) and build the project :
    ```bash
        cd test
        ./mvnw clean install
## Start Project

1. Start the Flask app : 

    ```bash
        python app.py
2. Start the SpringBoot app :
    ```bash
        ./mvnw spring-boot:run
## Contact Information

Zeyad Hassan 

Zeyadhassan5@gmail.com