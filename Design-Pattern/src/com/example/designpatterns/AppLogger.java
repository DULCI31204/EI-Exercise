/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.designpatterns;
/**
 *
 * @author sdulc
 */
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AppLogger {
    private static final Logger LOGGER = Logger.getLogger("com.example.designpatterns");

    static {
        LOGGER.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        LOGGER.addHandler(handler);
        LOGGER.setUseParentHandlers(false);
    }

    private AppLogger() {}

    public static Logger getLogger() {
        return LOGGER;
    }
}
