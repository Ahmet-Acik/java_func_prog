package org.ahmet.functional2;

import java.util.function.Function;

public class AdvancedFunctionalConcepts {
    public static void main(String[] args) {
        // 1. Lambda Composability with andThen and compose
        System.out.println("**Lambda Composability**");

        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        Function<Integer, Integer> add3 = x -> x + 3;

        // Using andThen (executes multiplyBy2 first, then add3)
        Function<Integer, Integer> multiplyThenAdd = multiplyBy2.andThen(add3);
        System.out.println("Result of (x * 2) andThen (x + 3) for 5: " + multiplyThenAdd.apply(5));

        // Using compose (executes add3 first, then multiplyBy2)
        Function<Integer, Integer> addThenMultiply = multiplyBy2.compose(add3);
        System.out.println("Result of (x + 3) compose (x * 2) for 5: " + addThenMultiply.apply(5));

        // 2. Closures in Java
        System.out.println("\n**Closures in Java**");

        int baseValue = 10; // Effectively final variable
        Function<Integer, Integer> addBaseValue = x -> x + baseValue;
        System.out.println("Result of adding baseValue (10) to 5: " + addBaseValue.apply(5));

        // 3. Pure Functions
        System.out.println("\n**Pure Functions**");

        Function<Integer, Integer> pureFunction = x -> x * x; // No side effects
        System.out.println("Square of 4 using pure function: " + pureFunction.apply(4));

        // Impure function example (for comparison)
        final int[] state = {0};
        Function<Integer, Integer> impureFunction = x -> {
            state[0] += x; // Modifies the value inside the array
            return state[0];
        };
        System.out.println("Impure function result for 5: " + impureFunction.apply(5));
        System.out.println("Impure function result for 3: " + impureFunction.apply(3));
    }
}