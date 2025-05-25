package org.ahmet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamExamples {
    public static void main(String[] args) {
        // Example 1: Sequential stream
        List<Integer> sequentialSquares = IntStream.rangeClosed(1, 10)
                                                   .map(n -> n * n)
                                                   .boxed()
                                                   .collect(Collectors.toList());
        System.out.println("Sequential squares: " + sequentialSquares);

        // Example 2: Parallel stream
        List<Integer> parallelSquares = IntStream.rangeClosed(1, 10)
                                                 .parallel()
                                                 .map(n -> n * n)
                                                 .boxed()
                                                 .collect(Collectors.toList());
        System.out.println("Parallel squares: " + parallelSquares);

        // Example 3: Performance comparison
        long startSequential = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1_000_000)
                 .map(n -> n * n)
                 .sum();
        long endSequential = System.currentTimeMillis();
        System.out.println("Sequential stream time: " + (endSequential - startSequential) + " ms");

        long startParallel = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1_000_000)
                 .parallel()
                 .map(n -> n * n)
                 .sum();
        long endParallel = System.currentTimeMillis();
        System.out.println("Parallel stream time: " + (endParallel - startParallel) + " ms");

        // Example 4: Using parallel stream with custom collector
        List<String> names = List.of("Ahmet", "John", "Zara", "Emily");
        String joinedNames = names.parallelStream()
                                  .collect(Collectors.joining(", "));
        System.out.println("Joined names (parallel): " + joinedNames);

        // Example 5: Parallel stream with filtering
        List<Integer> evenNumbers = IntStream.rangeClosed(1, 20)
                                             .parallel()
                                             .filter(n -> n % 2 == 0)
                                             .boxed()
                                             .collect(Collectors.toList());
        System.out.println("Even numbers (parallel): " + evenNumbers);

        // Example 6: Parallel stream with map and reduce
        int sumOfSquares = IntStream.rangeClosed(1, 100)
                                    .parallel()
                                    .map(n -> n * n)
                                    .sum();
        System.out.println("Sum of squares (parallel): " + sumOfSquares);


        // Example 7: Parallel stream with forEach
        System.out.println("Numbers from 1 to 10 (parallel forEach):");
        IntStream.rangeClosed(1, 10)
                 .parallel()
                 .forEach(n -> System.out.println("Number: " + n));

        // Example 8: Parallel stream with sorted
        List<Integer> sortedNumbers = IntStream.rangeClosed(1, 10)
                                               .parallel()
                                               .boxed()
                                               .sorted()
                                               .collect(Collectors.toList());
        System.out.println("Sorted numbers (parallel): " + sortedNumbers);


        // Example 9: Parallel stream with distinct
        List<Integer> distinctNumbers = IntStream.of(1, 2, 2, 3, 4, 4, 5)
                                                  .parallel()
                                                  .distinct()
                                                  .boxed()
                                                  .collect(Collectors.toList());
        System.out.println("Distinct numbers (parallel): " + distinctNumbers);


        // Example 10: Parallel stream with limit
        List<Integer> limitedNumbers = IntStream.rangeClosed(1, 100)
                .parallel()
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Limited numbers (parallel): " + limitedNumbers);

        // Example 11: Parallel stream with skip
        List<Integer> skippedNumbers = IntStream.rangeClosed(1, 20)
                .parallel()
                .skip(5)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Skipped first 5 numbers (parallel): " + skippedNumbers);


        // Example 12: Parallel stream with flatMap
        List<List<Integer>> nestedLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        List<Integer> flattenedList = nestedLists.parallelStream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened list (parallel): " + flattenedList);
    }
}