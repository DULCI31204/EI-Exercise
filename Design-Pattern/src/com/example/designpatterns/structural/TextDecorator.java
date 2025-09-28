/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.designpatterns.structural;

/**
 *
 * @author sdulc
 */
public abstract class TextDecorator implements Text {
    protected final Text decoratedText;

    public TextDecorator(Text decoratedText) {
        if (decoratedText == null) {
            throw new IllegalArgumentException("Decorated Text cannot be null");
        }
        this.decoratedText = decoratedText;
    }

    @Override
    public String getText() {
        return decoratedText.getText();
    }
}