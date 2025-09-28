/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.marsrover.rover;

/**
 *
 * @author sdulc
 */
import com.example.marsrover.grid.Grid;

import java.util.logging.Logger;
import com.example.marsrover.AppLogger;

public class Rover {
    private int x;
    private int y;
    private Direction direction;
    private final Grid grid;
    private static final Logger logger = AppLogger.getLogger();

    public Rover(int startX, int startY, Direction startDirection, Grid grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Grid cannot be null");
        }
        if (startX < 0 || startY < 0 || startX >= grid.getWidth() || startY >= grid.getHeight()) {
            throw new IllegalArgumentException("Starting position out of bounds");
        }
        this.x = startX;
        this.y = startY;
        this.direction = startDirection;
        this.grid = grid;
        logger.info("Rover initialized at (" + x + "," + y + ") facing " + direction);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Direction getDirection() { return direction; }
    public Grid getGrid() { return grid; }

    public void setPosition(int newX, int newY) {
        if (newX < 0 || newY < 0 || newX >= grid.getWidth() || newY >= grid.getHeight()) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        this.x = newX;
        this.y = newY;
    }

    public void setDirection(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction cannot be null");
        }
        this.direction = direction;
    }

    public String getStatusReport() {
        return String.format("Rover is at (%d, %d) facing %s. No Obstacles detected.", x, y, direction.toString());
    }
}
