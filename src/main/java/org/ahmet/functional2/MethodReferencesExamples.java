package org.ahmet.functional2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferencesExamples {
    public static void main(String[] args) {
        // 1. Static Method Reference
        System.out.println("**Static Method Reference**");
        Function<Integer, String> staticMethodRef = String::valueOf; // Method reference
        System.out.println("Static method reference result: " + staticMethodRef.apply(123));

        Function<Integer, String> staticLambda = x -> String.valueOf(x); // Equivalent lambda
        System.out.println("Lambda result: " + staticLambda.apply(123));

        // 2. Instance Method Reference of a Particular Object
        System.out.println("\n**Instance Method Reference of a Particular Object**");
        String message = "Hello, Method References!";
        Supplier<Integer> instanceMethodRef = message::length; // Method reference
        System.out.println("Instance method reference result: " + instanceMethodRef.get());

        Supplier<Integer> instanceLambda = () -> message.length(); // Equivalent lambda
        System.out.println("Lambda result: " + instanceLambda.get());

        // 3. Instance Method Reference of an Arbitrary Object of a Particular Type
        System.out.println("\n**Instance Method Reference of an Arbitrary Object of a Particular Type**");
        Function<String, Integer> arbitraryMethodRef = String::length; // Method reference
        System.out.println("Arbitrary method reference result: " + arbitraryMethodRef.apply("Hello"));

        Function<String, Integer> arbitraryLambda = str -> str.length(); // Equivalent lambda
        System.out.println("Lambda result: " + arbitraryLambda.apply("Hello"));

        // 4. Constructor Reference
        System.out.println("\n**Constructor Reference**");
        Supplier<StringBuilder> constructorRef = StringBuilder::new; // Method reference
        System.out.println("Constructor reference result: " + constructorRef.get().append("Hello"));

        Supplier<StringBuilder> constructorLambda = () -> new StringBuilder(); // Equivalent lambda
        System.out.println("Lambda result: " + constructorLambda.get().append("Hello"));
    }
}