/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.designpatterns.structural;

/**
 *
 * @author sdulc
 */
public class TextImpl implements Text {
    private final String text;

    public TextImpl(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
