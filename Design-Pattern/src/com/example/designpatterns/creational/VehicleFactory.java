/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.designpatterns.creational;

/**
 *
 * @author sdulc
 */
public final class VehicleFactory {
    private VehicleFactory() {}

    public static Vehicle getVehicle(String vehicleType) {
        if (vehicleType == null || vehicleType.isEmpty()) {
            throw new IllegalArgumentException("Vehicle type cannot be null or empty");
        }
        switch (vehicleType.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
}
