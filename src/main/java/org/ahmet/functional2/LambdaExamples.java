package org.ahmet.functional2;

import java.util.function.Function;

public class LambdaExamples {
    public static void main(String[] args) {
        // 1. Introducing Lambda Expressions
        System.out.println("**Introducing Lambda Expressions**");
        Runnable runnable = () -> System.out.println("This is a lambda expression!");
        runnable.run();

        // 2. Lambda Expression Examples
        System.out.println("\n**Lambda Expression Examples**");
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));

        // Custom functional interface
        MathOperation addition = (a, b) -> a + b;
        System.out.println("Addition of 3 and 7: " + addition.operate(3, 7));

        // 3. Functional Interfaces and SAM
        System.out.println("\n**Functional Interfaces and SAM**");
        System.out.println("A functional interface has exactly one abstract method (SAM).");
        System.out.println("Example: MathOperation interface used above.");

        // 4. Typing Lambdas with Interfaces
        System.out.println("\n**Typing Lambdas with Interfaces**");
        MathOperation multiplication = (a, b) -> a * b;
        System.out.println("Multiplication of 4 and 6: " + multiplication.operate(4, 6));

        // 5. Why Single Abstract Method
        System.out.println("\n**Why Single Abstract Method**");
        System.out.println("Lambdas work with functional interfaces because they have a single abstract method.");
    }

    // Custom functional interface
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }
}