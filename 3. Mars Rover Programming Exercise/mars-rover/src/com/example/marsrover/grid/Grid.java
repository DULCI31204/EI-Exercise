/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.marsrover.grid;

/**
 *
 * @author sdulc
 */
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.example.marsrover.AppLogger;

public class Grid implements GridComponent {
    private final int width;
    private final int height;
    private final List<GridComponent> children = new ArrayList<>();
    private static final Logger logger = AppLogger.getLogger();

    public Grid(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Grid size must be positive");
        }
        this.width = width;
        this.height = height;
        logger.info("Grid created with size: " + width + "x" + height);
    }

    public void addComponent(GridComponent component) {
        children.add(component);
        logger.info("Added grid component: " + component);
    }

    @Override
    public boolean hasObstacle(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            logger.warning("Position out of grid bounds: (" + x + "," + y + ")");
            return true; // Treat out of bounds as obstacle
        }
        for (GridComponent component : children) {
            if (component.hasObstacle(x, y)) {
                return true;
            }
        }
        return false;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
