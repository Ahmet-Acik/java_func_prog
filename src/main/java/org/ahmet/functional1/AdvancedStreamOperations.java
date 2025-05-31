package org.ahmet.functional1;

import java.util.*;
import java.util.stream.Collectors;

public class AdvancedStreamOperations {
    public static void main(String[] args) {
        // Example 1: Grouping by even and odd numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> groupedByEvenOdd = numbers.stream()
                                                              .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Grouped by even/odd: " + groupedByEvenOdd);

        // Example 2: Flattening nested collections with flatMap
        List<List<String>> nestedLists = Arrays.asList(
            Arrays.asList("Ahmet", "John"),
            Arrays.asList("Zara", "Emily")
        );
        List<String> flattenedList = nestedLists.stream()
                                                .flatMap(Collection::stream)
                                                .collect(Collectors.toList());
        System.out.println("Flattened list: " + flattenedList);

        // Example 3: Using peek for debugging
        List<Integer> processedNumbers = numbers.stream()
                                                .peek(n -> System.out.println("Original: " + n))
                                                .map(n -> n * n)
                                                .peek(n -> System.out.println("Squared: " + n))
                                                .collect(Collectors.toList());
        System.out.println("Processed numbers: " + processedNumbers);
    }
}