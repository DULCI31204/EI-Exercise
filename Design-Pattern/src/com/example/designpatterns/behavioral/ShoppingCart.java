/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.designpatterns.behavioral;

/**
 *
 * @author sdulc
 */
import java.util.logging.Logger;
import com.example.designpatterns.AppLogger;

public class ShoppingCart {
    private DiscountStrategy discountStrategy;
    private static final Logger logger = AppLogger.getLogger();

    public ShoppingCart(DiscountStrategy discountStrategy) {
        if (discountStrategy == null) {
            throw new IllegalArgumentException("DiscountStrategy cannot be null");
        }
        this.discountStrategy = discountStrategy;
        logger.info("ShoppingCart created with strategy: " + discountStrategy.getClass().getSimpleName());
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        if (discountStrategy == null) {
            throw new IllegalArgumentException("DiscountStrategy cannot be null");
        }
        this.discountStrategy = discountStrategy;
        logger.info("Discount strategy changed to: " + discountStrategy.getClass().getSimpleName());
    }

    public double calculatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        double finalPrice = discountStrategy.applyDiscount(price);
        logger.info("Price after discount: " + finalPrice);
        return finalPrice;
    }
}
