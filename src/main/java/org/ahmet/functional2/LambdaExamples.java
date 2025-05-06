package org.ahmet.functional2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExamples {
    public static void main(String[] args) {
        // 1. Introducing Lambda Expressions
        System.out.println("**Introducing Lambda Expressions**");
        Runnable runnable = () -> System.out.println("This is a lambda expression!");
        runnable.run();

        // 2. Lambda Expression using Function functional interface Examples
        System.out.println("\n**Lambda Expression Examples**");
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));  // Functional apply()

        // Lambda Expression using Consumer functional interface
        System.out.println("\n**Using Lambda with Consumer**");
        Consumer<String> print = message -> System.out.println("Message: " + message);
        print.accept("Hello, World!");  // Consumer accept()

        // Lambda Expression using  Supplier functional interface
        System.out.println("\n**Using Lambda with Supplier**");
        Supplier<String> supplier = () -> "Hello from Supplier!";
        System.out.println(supplier.get());  // Supplier get()

        //Lambda Expression using Predicate functional interface
        System.out.println("\n**Using Lambda with Predicate**");
       Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));  // Predicate test()

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