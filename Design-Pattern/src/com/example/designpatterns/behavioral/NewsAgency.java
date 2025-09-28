/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.designpatterns.behavioral;
/**
 *
 * @author sdulc
 */
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.example.designpatterns.AppLogger;

public class NewsAgency {
    private final List<Subscriber> subscribers = new ArrayList<>();
    private static final Logger logger = AppLogger.getLogger();

    public void subscribe(Subscriber subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("Subscriber cannot be null");
        }
        subscribers.add(subscriber);
        logger.info("Subscriber added: " + subscriber);
    }

    public void notifySubscribers(String message) {
        if (message == null || message.isEmpty()) {
            logger.warning("Empty message passed to notifySubscribers");
            return;
        }
        logger.info("Notifying subscribers: " + message);
        for (Subscriber subscriber : subscribers) {
            try {
                subscriber.update(message);
            } catch (Exception e) {
                logger.severe("Failed to update subscriber: " + e.getMessage());
            }
        }
    }
}