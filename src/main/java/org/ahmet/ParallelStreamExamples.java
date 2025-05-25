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



    }
}