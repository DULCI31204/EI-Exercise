/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.designpatterns.behavioral;

/**
 *
 * @author sdulc
 */
public class PercentageDiscount implements DiscountStrategy {
    private final double percent;

    public PercentageDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Discount percent must be between 0 and 100");
        }
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * percent / 100);
    }
}
