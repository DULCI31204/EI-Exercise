/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.designpatterns.creational;

/**
 *
 * @author sdulc
 */
import java.util.logging.Logger;
import com.example.designpatterns.AppLogger;

public final class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private static final Logger logger = AppLogger.getLogger();
    private boolean connected;

    private DatabaseConnection() {
        // Simulate connection setup
        this.connected = true;
        logger.info("Database connection established.");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public boolean isConnected() {
        return connected;
    }

    public void disconnect() {
        connected = false;
        logger.info("Database connection closed.");
    }
}
