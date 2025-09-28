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

public class MoveCommand implements Command {
    private static final Logger logger = AppLogger.getLogger();

    @Override
    public void execute(Rover rover) {
        int nextX = rover.getX();
        int nextY = rover.getY();

        switch (rover.getDirection()) {
            case N:
                nextY += 1;
                break;
            case S:
                nextY -= 1;
                break;
            case E:
                nextX += 1;
                break;
            case W:
                nextX -= 1;
                break;
        }

        if (rover.getGrid().hasObstacle(nextX, nextY)) {
            logger.warning("Obstacle detected or out of bounds at (" + nextX + "," + nextY + "). Move blocked.");
        } else {
            rover.setPosition(nextX, nextY);
            logger.info("Moved to (" + nextX + "," + nextY + ")");
        }
    }
}
