/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.designpatterns.behavioral;
/**
 *
 * @author sdulc
 */
import java.util.logging.Logger;
import com.example.designpatterns.AppLogger;

public class ConsoleSubscriber implements Subscriber {
    private final String name;
    private static final Logger logger = AppLogger.getLogger();

    public ConsoleSubscriber(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Subscriber name cannot be null or empty");
        }
        this.name = name;
        logger.info("ConsoleSubscriber created: " + name);
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received news: " + message);
    }

    @Override
    public String toString() {
        return "Subscriber{" + "name='" + name + '\'' + '}';
    }
}
