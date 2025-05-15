package org.ahmet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        // Example 1: Creating a stream from a list
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("A"))
                                          .toList();
        System.out.println("Filtered names: " + filteredNames);

        // Example 2: Mapping and sorting
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3);
        List<Integer> squaredSortedNumbers = numbers.stream()
                                                    .map(n -> n * n)
                                                    .sorted()
                                                    .toList();
        System.out.println("Squared and sorted numbers: " + squaredSortedNumbers);

        // Example 3: Reducing a stream
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("Sum of numbers: " + sum);

        // Example 4: Using forEach
        System.out.println("Names in uppercase:");
        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}