/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.designpatterns.structural;

/**
 *
 * @author sdulc
 */
public class WordCountDecorator extends TextDecorator {
    public WordCountDecorator(Text decoratedText) {
        super(decoratedText);
    }

    public int getWordCount() {
        String text = getText();
        if (text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }
}
