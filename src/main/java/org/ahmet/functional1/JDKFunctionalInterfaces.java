package org.ahmet.functional1;

import java.util.function.*;

public class JDKFunctionalInterfaces {
    public static void main(String[] args) {
        // Example 1: Function - Transform an Integer to a String
        Function<Integer, String> intToString = x -> "Number: " + x;
        System.out.println(intToString.apply(42));

        // Example 2: Consumer - Print a message
        Consumer<String> printer = message -> System.out.println("Message: " + message);
        printer.accept("Hello, Functional Interfaces!");

        // Example 3: Supplier - Provide a random number
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random number: " + randomSupplier.get());

        // Example 4: Predicate - Check if a number is even
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));
        System.out.println("Is 15 even? " + isEven.test(15));
    }
}