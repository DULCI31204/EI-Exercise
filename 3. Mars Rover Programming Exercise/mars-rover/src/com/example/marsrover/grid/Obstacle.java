/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.marsrover.grid;

/**
 *
 * @author sdulc
 */
public class Obstacle implements GridComponent {
    private final int x;
    private final int y;

    public Obstacle(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Obstacle position must be non-negative");
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean hasObstacle(int x, int y) {
        return this.x == x && this.y == y;
    }

    @Override
    public String toString() {
        return "Obstacle(" + x + "," + y + ")";
    }
}