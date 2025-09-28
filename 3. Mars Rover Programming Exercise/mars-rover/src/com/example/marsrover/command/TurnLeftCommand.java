/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.marsrover.command;

/**
 *
 * @author sdulc
 */
import com.example.marsrover.rover.Direction;
import com.example.marsrover.rover.Rover;
import java.util.logging.Logger;
import com.example.marsrover.AppLogger;

public class TurnLeftCommand implements Command {
    private static final Logger logger = AppLogger.getLogger();

    @Override
    public void execute(Rover rover) {
        Direction newDirection = rover.getDirection().turnLeft();
        rover.setDirection(newDirection);
        logger.info("Turned left. Now facing " + newDirection);
    }
}
