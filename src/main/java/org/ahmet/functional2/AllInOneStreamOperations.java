package org.ahmet.functional2;

import java.util.*;
import java.util.stream.Collectors;

public class AllInOneStreamOperations {
    public static void main(String[] args) {
        // Example 1: Partitioning numbers into even and odd
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> evenOddPartition = numbers.stream()
                                                              .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned into even/odd: " + evenOddPartition);

        // Example 2: Flattening nested lists into a single list
        List<List<String>> nestedLists = Arrays.asList(
            Arrays.asList("Ahmet", "John"),
            Arrays.asList("Zara", "Emily")
        );
        List<String> flattenedList = nestedLists.stream()
                                                .flatMap(Collection::stream) // Flatten each inner list
                                                .collect(Collectors.toList());
        System.out.println("Flattened list: " + flattenedList);

        // Example 3: Debugging with peek
        List<Integer> squaredNumbers = numbers.stream()
                                              .peek(n -> System.out.println("Original: " + n)) // Debug original value
                                              .map(n -> n * n) // Square each number
                                              .peek(n -> System.out.println("Squared: " + n)) // Debug squared value
                                              .collect(Collectors.toList());
        System.out.println("Squared numbers: " + squaredNumbers);

        // Example 4: Grouping by first letter of names
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Anna");
        Map<Character, List<String>> groupedByFirstLetter = names.stream()
                                                                 .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("Grouped by first letter: " + groupedByFirstLetter);

        // Example 5: Counting occurrences of names
        List<String> duplicateNames = Arrays.asList("Alice", "Bob", "Alice", "David", "Bob");
        Map<String, Long> nameCounts = duplicateNames.stream()
                                                     .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        System.out.println("Name counts: " + nameCounts);

        // Example 6: Joining strings with a delimiter
        String joinedNames = names.stream()
                                  .collect(Collectors.joining(", ")); // Join names with ", "
        System.out.println("Joined names: " + joinedNames);

        // Example 7: Calculating average of numbers
        double average = numbers.stream()
                                .mapToInt(Integer::intValue) // Convert to IntStream
                                .average() // Calculate average
                                .orElse(0); // Default to 0 if empty
        System.out.println("Average of numbers: " + average);

        // Example 8: Custom reduction to calculate product of numbers
        int product = numbers.stream()
                             .reduce(1, (a, b) -> a * b); // Multiply all numbers
        System.out.println("Product of numbers: " + product);

        // Example 9: Sorting names alphabetically
        List<String> sortedNames = names.stream()
                                        .sorted() // Sort alphabetically
                                        .collect(Collectors.toList());
        System.out.println("Sorted names: " + sortedNames);

        // Example 10: Summarizing statistics for numbers
        IntSummaryStatistics stats = numbers.stream()
                                            .mapToInt(Integer::intValue) // Convert to IntStream
                                            .summaryStatistics(); // Get statistics
        System.out.println("Statistics: " + stats);
    }
}