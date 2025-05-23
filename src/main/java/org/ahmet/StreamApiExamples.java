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
}