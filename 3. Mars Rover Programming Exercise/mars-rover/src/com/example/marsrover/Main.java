/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.marsrover;

/**
 *
 * @author sdulc
 */
import com.example.marsrover.command.*;
import com.example.marsrover.grid.*;
import com.example.marsrover.rover.*;

import java.util.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = AppLogger.getLogger();

    public static void main(String[] args) {
        logger.info("Mars Rover simulation started.");

        int gridWidth = InputReader.readInt("Enter grid width (e.g., 10): ", 1, 100);
        int gridHeight = InputReader.readInt("Enter grid height (e.g., 10): ", 1, 100);

        Grid grid = new Grid(gridWidth, gridHeight);

        // Add obstacles
        String addObstacles = InputReader.readLine("Add obstacles? (y/n): ");
        while (addObstacles.equalsIgnoreCase("y")) {
            int ox = InputReader.readInt("Obstacle X: ", 0, gridWidth - 1);
            int oy = InputReader.readInt("Obstacle Y: ", 0, gridHeight - 1);
            grid.addComponent(new Obstacle(ox, oy));
            addObstacles = InputReader.readLine("Add more obstacles? (y/n): ");
        }

        int startX = InputReader.readInt("Enter rover start X position: ", 0, gridWidth - 1);
        int startY = InputReader.readInt("Enter rover start Y position: ", 0, gridHeight - 1);

        Direction startDirection = null;
        while (startDirection == null) {
            String dirInput = InputReader.readLine("Enter rover starting direction (N, E, S, W): ").toUpperCase();
            try {
                startDirection = Direction.valueOf(dirInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid direction, enter N, E, S, or W.");
            }
        }

        Rover rover = new Rover(startX, startY, startDirection, grid);

        // Command mapping
        Map<Character, Command> commandMap = new HashMap<>();
        commandMap.put('M', new MoveCommand());
        commandMap.put('L', new TurnLeftCommand());
        commandMap.put('R', new TurnRightCommand());

        System.out.println("Enter command sequence (M = move, L = turn left, R = turn right), e.g. MMRMLM:");
        String commands = InputReader.readLine("Commands: ").toUpperCase();

        for (char cmdChar : commands.toCharArray()) {
            Command cmd = commandMap.get(cmdChar);
            if (cmd == null) {
                System.out.println("Invalid command '" + cmdChar + "'. Skipping.");
                logger.warning("Invalid command input: " + cmdChar);
                continue;
            }
            cmd.execute(rover);
        }

        System.out.println("Final Position: (" + rover.getX() + ", " + rover.getY() + ", " + rover.getDirection() + ")");
        System.out.println("Status Report: " + rover.getStatusReport());

        logger.info("Mars Rover simulation ended.");
    }
}