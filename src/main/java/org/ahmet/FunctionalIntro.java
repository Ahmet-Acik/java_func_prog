// FunctionalIntro.java
package org.ahmet;

import java.util.function.Function;

public class FunctionalIntro {
    public static void main(String[] args) {
        // First-class function example
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));

        // Comparing functional and object-oriented approaches
        System.out.println("Functional approach: " + square.apply(10));

        // Object-oriented approach
        SquareCalculator calculator = new SquareCalculator();
        System.out.println("Object-oriented approach: " + calculator.calculate(10));
    }
}

// Object-oriented approach example
class SquareCalculator {
    public int calculate(int x) {
        return x * x;
    }
}