/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.designpatterns;
/**
 *
 * @author sdulc
 */
import com.example.designpatterns.behavioral.*;
import com.example.designpatterns.creational.*;
import com.example.designpatterns.structural.*;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = AppLogger.getLogger();

    public static void main(String[] args) {
        logger.info("Application started.");
        NewsAgency agency = new NewsAgency();

        boolean running = true;
        while (running) {
            int choice = InputReader.readInt(
                "\nMenu:\n" +
                "1. Add Subscriber (Observer)\n" +
                "2. Publish News (Observer)\n" +
                "3. Test DB Connection (Singleton)\n" +
                "4. Make Payment (Adapter)\n" +
                "5. Calculate Discount (Strategy)\n" +
                "6. Create and Drive Vehicle (Factory Method)\n" +
                "7. Text Processing with Word Count (Decorator)\n" +
                "8. Exit\nChoose an option: ", 1, 8);

            try {
                switch (choice) {
                    case 1:
                        String name = InputReader.readLine("Enter subscriber name: ");
                        agency.subscribe(new ConsoleSubscriber(name));
                        break;

                    case 2:
                        String news = InputReader.readLine("Enter news message: ");
                        agency.notifySubscribers(news);
                        break;

                    case 3:
                        DatabaseConnection db = DatabaseConnection.getInstance();
                        System.out.println("Database connected: " + db.isConnected());
                        break;

                    case 4:
                        double amount = Double.parseDouble(InputReader.readLine("Enter payment amount: "));
                        PaymentProcessor paymentProcessor = new PaymentAdapter(new OldPaymentGateway());
                        System.out.println(paymentProcessor.pay(amount));
                        break;

                    case 5:
                        double price = Double.parseDouble(InputReader.readLine("Enter product price: "));
                        double discountPercent = Double.parseDouble(InputReader.readLine("Enter discount percent (0-100): "));
                        DiscountStrategy discountStrategy = new PercentageDiscount(discountPercent);
                        ShoppingCart cart = new ShoppingCart(discountStrategy);
                        double finalPrice = cart.calculatePrice(price);
                        System.out.println("Final price after discount: " + finalPrice);
                        break;

                    case 6:
                        String vehicleType = InputReader.readLine("Enter vehicle type (car/bike): ");
                        Vehicle vehicle = VehicleFactory.getVehicle(vehicleType);
                        System.out.println(vehicle.drive());
                        break;

                    case 7:
                        String inputText = InputReader.readLine("Enter text: ");
                        Text text = new TextImpl(inputText);
                        WordCountDecorator decoratedText = new WordCountDecorator(text);
                        System.out.println("Text: " + decoratedText.getText());
                        System.out.println("Word count: " + decoratedText.getWordCount());
                        break;

                    case 8:
                        running = false;
                        System.out.println("Exiting application...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                logger.severe("Error occurred: " + e.getMessage());
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        logger.info("Application terminated.");
    }
}
