/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.marsrover.rover;

/**
 *
 * @author sdulc
 */
public enum Direction {
    N, E, S, W;

    public Direction turnLeft() {
        switch (this) {
            case N: return W;
            case W: return S;
            case S: return E;
            case E: return N;
        }
        throw new IllegalStateException("Invalid direction");
    }

    public Direction turnRight() {
        switch (this) {
            case N: return E;
            case E: return S;
            case S: return W;
            case W: return N;
        }
        throw new IllegalStateException("Invalid direction");
    }

    @Override
    public String toString() {
        switch (this) {
            case N: return "North";
            case E: return "East";
            case S: return "South";
            case W: return "West";
        }
        return super.toString();
    }
}
