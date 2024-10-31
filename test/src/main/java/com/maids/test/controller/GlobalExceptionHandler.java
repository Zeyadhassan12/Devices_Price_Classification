package com.maids.test.controller;

// import com.maids.test.Exceptions.DeviceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {  // Changed the class name

    // @ExceptionHandler(DeviceException.class)
    // public ResponseEntity<String> handleDeviceException(DeviceException ex) {
    //     return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    // }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}

