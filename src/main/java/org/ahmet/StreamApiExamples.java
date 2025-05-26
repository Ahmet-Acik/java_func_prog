package org.ahmet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiExamples {
    public static void main(String[] args) {
        // Example 1: Filtering even numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .toList();
        System.out.println("Even numbers: " + evenNumbers);

        // Example 2: Mapping numbers to their squares
        List<Integer> squares = numbers.stream()
                                       .map(n -> n * n)
                                       .toList();
        System.out.println("Squares: " + squares);

        // Example 3: Reducing to find the sum of all numbers
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("Sum of numbers: " + sum);

        // Example 4: Using forEach to print each number
        System.out.println("All numbers:");
        numbers.stream()
               .forEach(System.out::println);
    }

    // Example 5: Collecting names into a list
    public static List<String> collectNames() {
        List<String> names = Arrays.asList("Ahmet", "John", "Zara", "Emily");
        return names.stream()
                    .collect(Collectors.toList());
    }

    // Example 6: Joining names into a single string
    public static String joinNames() {
        List<String> names = Arrays.asList("Ahmet", "John", "Zara", "Emily");
        return names.stream()
                    .collect(Collectors.joining(", "));
    }

    // Example 7: Counting the number of names
    public static long countNames() {
        List<String> names = Arrays.asList("Ahmet", "John", "Zara", "Emily");
        return names.stream()
                    .count();
    }

    // Example 8: Finding the maximum number
    public static int findMaxNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return numbers.stream()
                      .max(Integer::compareTo)
                      .orElseThrow(() -> new RuntimeException("No maximum found"));
    }

    // Example 9: Finding the minimum number
    public static int findMinNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return numbers.stream()
                      .min(Integer::compareTo)
                      .orElseThrow(() -> new RuntimeException("No minimum found"));
    }

    // Example 10: Checking if all numbers are positive
    public static boolean allNumbersPositive() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, -6, 7, 8, 9, 10);
        return numbers.stream()
                      .allMatch(n -> n > 0);
    }


    // Example 11: Checking if any number is even
    public static boolean anyNumberEven() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
        return numbers.stream()
                      .anyMatch(n -> n % 2 == 0);
    }


}