package org.ahmet.functional2;

import java.util.function.Function;

public class FunctionalJavaIntro {
    public static void main(String[] args) {
        // 1. What is Functional Programming?
        System.out.println("Functional programming focuses on using functions as first-class citizens.");

        // 2. Functions vs Methods
        System.out.println("\n**Functions vs Methods**");
        Function<Integer, Integer> squareFunction = x -> x * x; // Function
        System.out.println("Square using function: " + squareFunction.apply(5));

        SquareCalculator calculator = new SquareCalculator(); // Method requires class instantiation
        System.out.println("Square using method: " + calculator.calculate(5));

        // 3. Limitations of Object-Oriented Programming
        System.out.println("\n**Limitations of OOP**");
        System.out.println("OOP often requires creating multiple classes for simple operations.");
        System.out.println("Functional programming reduces boilerplate code by using functions directly.");

        // 4. First-Class Functions
        System.out.println("\n**First-Class Functions**");
        Function<Integer, Integer> doubleFunction = x -> x * 2;
        System.out.println("Double of 5: " + doubleFunction.apply(5));

        // Passing functions as arguments
        System.out.println("Result of applying a function: " + applyFunction(10, squareFunction));
    }

    // Example of passing a function as an argument
    public static int applyFunction(int value, Function<Integer, Integer> function) {
        return function.apply(value);
    }
}

// Supporting class for OOP example
class SquareCalculator {
    public int calculate(int x) {
        return x * x;
    }
}