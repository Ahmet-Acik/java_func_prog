package org.ahmet.functional2;

import java.util.function.*;

public class FunctionalInterfacesExamples {
    public static void main(String[] args) {
        // 1. Function Interface
        System.out.println("**Function Interface**");
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));

        // 2. Consumer Interface
        System.out.println("\n**Consumer Interface**");
        Consumer<String> printMessage = message -> System.out.println("Message: " + message);
        printMessage.accept("Hello, Functional Interfaces!");

        // 3. Supplier Interface
        System.out.println("\n**Supplier Interface**");
        Supplier<String> supplier = () -> "Hello from Supplier!";
        System.out.println(supplier.get());

        // 4. Predicate Interface
        System.out.println("\n**Predicate Interface**");
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        // 5. Function Arity with BiFunction
        System.out.println("\n**Function Arity with BiFunction**");
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum of 3 and 7: " + add.apply(3, 7));

        // 6. Operator Interfaces
        System.out.println("\n**Operator Interfaces**");
        UnaryOperator<Integer> doubleValue = x -> x * 2;
        System.out.println("Double of 6: " + doubleValue.apply(6));

        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Multiplication of 4 and 5: " + multiply.apply(4, 5));
    }
}