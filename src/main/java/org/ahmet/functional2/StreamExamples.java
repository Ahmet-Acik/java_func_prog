package org.ahmet.functional2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {
        // 1. Declarative Model
        System.out.println("**Declarative Model**");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(x -> x % 2 == 0) // Declarative filtering
                                           .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // 2. Stream Characteristics
        System.out.println("\n**Stream Characteristics**");
        System.out.println("Streams are:");
        System.out.println("- Lazy: Operations are not executed until terminal operation is invoked.");
        System.out.println("- Immutable: Original data source is not modified.");
        System.out.println("- Single-use: Streams cannot be reused once consumed.");

        // 3. Other Ways to Create Streams
        System.out.println("\n**Other Ways to Create Streams**");

        // Using Stream.of
        Stream<String> streamOf = Stream.of("A", "B", "C");
        System.out.println("Stream.of: " + streamOf.collect(Collectors.toList()));

        // Using Stream.iterate
        Stream<Integer> streamIterate = Stream.iterate(1, n -> n + 1).limit(5);
        System.out.println("Stream.iterate: " + streamIterate.collect(Collectors.toList()));

        // Using Stream.generate
        Stream<Double> streamGenerate = Stream.generate(Math::random).limit(3);
        System.out.println("Stream.generate: " + streamGenerate.collect(Collectors.toList()));

        // 4. The toList Method
        System.out.println("\n**The toList Method**");
        List<Integer> squares = IntStream.range(1, 6)
                                         .map(x -> x * x)
                                         .boxed()
                                         .toList(); // Collecting to a list
        System.out.println("Squares: " + squares);

        // 5. Three Key Elements in Streams API
        System.out.println("\n**Three Key Elements in Streams API**");
        System.out.println("- Source: The data source (e.g., collection, array).");
        System.out.println("- Intermediate Operations: Transformations (e.g., filter, map).");
        System.out.println("- Terminal Operation: Triggers processing (e.g., collect, forEach).");

        // 6. Stream Pipeline
        System.out.println("\n**Stream Pipeline**");
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");
        List<String> filteredNames = names.stream()
                                           .filter(name -> name.startsWith("A"))
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());
        System.out.println("Filtered and uppercased names: " + filteredNames);

        // 7. Parallel Streams
        System.out.println("\n**Parallel Streams**");
        List<Integer> parallelSquares = IntStream.range(1, 6)
                                                 .parallel() // Enable parallel processing
                                                 .map(x -> x * x)
                                                 .boxed()
                                                 .collect(Collectors.toList());
        System.out.println("Parallel squares: " + parallelSquares);

        // 8. Stream Operations
        System.out.println("\n**Stream Operations**");
        List<String> fruits = List.of("Apple", "Banana", "Cherry", "Date", "Elderberry");
        List<String> filteredFruits = fruits.stream()
                                             .filter(fruit -> fruit.length() > 5)
                                             .map(String::toUpperCase)
                                             .sorted()
                                             .collect(Collectors.toList());
        System.out.println("Filtered and sorted fruits: " + filteredFruits);

        // 9. Collectors
        System.out.println("\n**Collectors**");
        List<String> collectedFruits = fruits.stream()
                                              .filter(fruit -> fruit.startsWith("A"))
                                              .collect(Collectors.toList());
        System.out.println("Collected fruits starting with 'A': " + collectedFruits);

        // 10. Stream Reduction
        System.out.println("\n**Stream Reduction**");
        int sum = IntStream.range(1, 6)
                           .reduce(0, Integer::sum); // Reducing to a single value
        System.out.println("Sum of numbers from 1 to 5: " + sum);

        // 11. Stream forEach
        System.out.println("\n**Stream forEach**");
        System.out.println("Fruits in uppercase:");
        fruits.stream()
              .map(String::toUpperCase)
              .forEach(System.out::println); // forEach to print each element

        // 12. Stream FlatMap
        System.out.println("\n**Stream FlatMap**");
        List<List<String>> listOfLists = List.of(
            List.of("A", "B"),
            List.of("C", "D"),
            List.of("E", "F")
        );
        List<String> flatList = listOfLists.stream()
                                            .flatMap(List::stream) // Flattening the list of lists
                                            .collect(Collectors.toList());
        System.out.println("Flattened list: " + flatList);

        // 13. Stream Peek
        System.out.println("\n**Stream Peek**");
        List<Integer> peekedNumbers = IntStream.range(1, 6)
                                               .peek(x -> System.out.println("Processing: " + x)) // Peek to see intermediate values
                                               .map(x -> x * x)
                                               .boxed()
                                               .collect(Collectors.toList());
        System.out.println("Peeked numbers: " + peekedNumbers);

        // 14. Stream Distinct
        System.out.println("\n**Stream Distinct**");
        List<Integer> numbersWithDuplicates = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbersWithDuplicates.stream()
                                                             .distinct() // Removing duplicates
                                                             .collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers);

        // 15. Stream Limit and Skip
        System.out.println("\n**Stream Limit and Skip**");
        List<Integer> limitedNumbers = IntStream.range(1, 11)
                                                 .limit(5) // Limiting to first 5 elements
                                                 .boxed()
                                                 .collect(Collectors.toList());
        System.out.println("Limited numbers: " + limitedNumbers);

        List<Integer> skippedNumbers = IntStream.range(1, 11)
                                                 .skip(5) // Skipping first 5 elements
                                                 .boxed()
                                                 .collect(Collectors.toList());
        System.out.println("Skipped numbers: " + skippedNumbers);

        // 16. Stream FindFirst and FindAny
        System.out.println("\n**Stream FindFirst and FindAny**");
        List<Integer> numbersToFind = List.of(1, 2, 3, 4, 5);
        Integer firstEven = numbersToFind.stream()
                                          .filter(x -> x % 2 == 0)
                                          .findFirst() // Finding the first even number
                                          .orElse(null);
        System.out.println("First even number: " + firstEven);
        Integer anyEven = numbersToFind.stream()
                                        .filter(x -> x % 2 == 0)
                                        .findAny() // Finding any even number
                                        .orElse(null);
        System.out.println("Any even number: " + anyEven);

        // 17. Stream Count
        System.out.println("\n**Stream Count**");
        long count = numbersToFind.stream()
                                   .filter(x -> x % 2 == 0)
                                   .count(); // Counting even numbers
        System.out.println("Count of even numbers: " + count);

        // 18. Stream Grouping
        System.out.println("\n**Stream Grouping**");
        List<String> animals = List.of("Dog", "Cat", "Elephant", "Dog", "Cat");
        var groupedAnimals = animals.stream()
                                     .collect(Collectors.groupingBy(String::toString)); // Grouping by animal name
        System.out.println("Grouped animals: " + groupedAnimals);

        // 19. Stream Joining
        System.out.println("\n**Stream Joining**");
        String joinedAnimals = animals.stream()
                                       .collect(Collectors.joining(", ")); // Joining animal names
        System.out.println("Joined animals: " + joinedAnimals);

        // 20. Stream Partitioning
        System.out.println("\n**Stream Partitioning**");
        var partitionedNumbers = numbersToFind.stream()
                                               .collect(Collectors.partitioningBy(x -> x % 2 == 0)); // Partitioning even and odd numbers
        System.out.println("Partitioned numbers: " + partitionedNumbers);

        // 21. Stream Collectors
        System.out.println("\n**Stream Collectors**");
        List<String> collectedNames = names.stream()
                                            .filter(name -> name.startsWith("C"))
                                            .collect(Collectors.toList()); // Collecting names starting with 'C'
        System.out.println("Collected names starting with 'C': " + collectedNames);

        // 22. Stream CollectingAndThen
        System.out.println("\n**Stream CollectingAndThen**");
        List<String> collectedAndTransformed = names.stream()
                                                     .collect(Collectors.collectingAndThen(
                                                         Collectors.toList(),
                                                         list -> list.stream()
                                                                     .map(String::toUpperCase)
                                                                     .collect(Collectors.toList())
                                                     )); // Collecting and transforming
        System.out.println("Collected and transformed names: " + collectedAndTransformed);

        // 23. Stream CollectingBy
        System.out.println("\n**Stream CollectingBy**");
        var collectingByResult = names.stream()
                                       .collect(Collectors.groupingBy(name -> name.charAt(0))); // Collecting by first character
        System.out.println("Collecting by first character: " + collectingByResult);

        // 24. Stream CollectingAndThen with Mapping
        System.out.println("\n**Stream CollectingAndThen with Mapping**");
        List<String> collectedAndMapped = names.stream()
                                                .collect(Collectors.collectingAndThen(
                                                    Collectors.toList(),
                                                    list -> list.stream()
                                                                .map(String::toLowerCase)
                                                                .collect(Collectors.toList())
                                                )); // Collecting and mapping to lowercase
        System.out.println("Collected and mapped names: " + collectedAndMapped);

        // 25. Stream CollectingAndThen with Summarizing
        System.out.println("\n**Stream CollectingAndThen with Summarizing**");
        var summarizingResult = numbersToFind.stream()
                                              .collect(Collectors.collectingAndThen(
                                                  Collectors.summarizingInt(Integer::intValue),
                                                  summary -> "Count: " + summary.getCount() +
                                                             ", Sum: " + summary.getSum() +
                                                             ", Min: " + summary.getMin() +
                                                             ", Max: " + summary.getMax()
                                              )); // Collecting and summarizing
        System.out.println("Summarizing result: " + summarizingResult);

        // 26. Stream CollectingAndThen with Mapping and Joining
        System.out.println("\n**Stream CollectingAndThen with Mapping and Joining**");
        String joinedMapped = names.stream()
                                    .collect(Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                    .map(String::toLowerCase)
                                                    .collect(Collectors.joining(", "))
                                    )); // Collecting, mapping, and joining
        System.out.println("Joined and mapped names: " + joinedMapped);

        // 27. Stream CollectingAndThen with Grouping and Counting
        System.out.println("\n**Stream CollectingAndThen with Grouping and Counting**");
        var groupingAndCountingResult = names.stream()
                                              .collect(Collectors.collectingAndThen(
                                                  Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()),
                                                  map -> "Grouped and counted: " + map
                                              )); // Grouping and counting
        System.out.println(groupingAndCountingResult);

        // 28. Stream CollectingAndThen with Grouping and Mapping
        System.out.println("\n**Stream CollectingAndThen with Grouping and Mapping**");
        var groupingAndMappingResult = names.stream()
                                             .collect(Collectors.collectingAndThen(
                                                 Collectors.groupingBy(name -> name.charAt(0), Collectors.mapping(String::toUpperCase, Collectors.toList())),
                                                 map -> "Grouped and mapped: " + map
                                             )); // Grouping and mapping
        System.out.println(groupingAndMappingResult);


    }
}