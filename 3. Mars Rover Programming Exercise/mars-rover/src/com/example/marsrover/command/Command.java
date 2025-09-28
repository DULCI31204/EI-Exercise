/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.marsrover.command;

/**
 *
 * @author sdulc
 */
import com.example.marsrover.rover.Rover;

public interface Command {
    void execute(Rover rover);
}
