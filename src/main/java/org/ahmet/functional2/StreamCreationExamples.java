package org.ahmet.functional2;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationExamples {
    public static void main(String[] args) {
        // 1. Creating a stream from a collection
        List<String> list = Arrays.asList("Alice", "Bob", "Charlie");
        Stream<String> streamFromList = list.stream();
        System.out.println("Stream from List:");
        streamFromList.forEach(System.out::println);

        // 2. Creating a stream from an array
        String[] array = {"Ahmet", "John", "Zara"};
        Stream<String> streamFromArray = Arrays.stream(array);
        System.out.println("\nStream from Array:");
        streamFromArray.forEach(System.out::println);

        // 3. Creating a stream using Stream.of
        Stream<String> streamOf = Stream.of("One", "Two", "Three");
        System.out.println("\nStream using Stream.of:");
        streamOf.forEach(System.out::println);

        // 4. Creating an infinite stream using Stream.iterate
        System.out.println("\nInfinite Stream using Stream.iterate (first 5 elements):");
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
        infiniteStream.limit(5).forEach(System.out::println);

        // 5. Creating an infinite stream using Stream.generate
        System.out.println("\nInfinite Stream using Stream.generate (first 5 elements):");
        Stream<Double> randomNumbers = Stream.generate(Math::random);
        randomNumbers.limit(5).forEach(System.out::println);

        // 6. Creating a stream from a primitive range (IntStream)
        System.out.println("\nStream from IntStream.range:");
        IntStream.range(1, 5).forEach(System.out::println);

        // 7. Creating a stream from a primitive range (IntStream.rangeClosed)
        System.out.println("\nStream from IntStream.rangeClosed:");
        IntStream.rangeClosed(1, 5).forEach(System.out::println);


        // 8. Creating a stream from a file (requires try-with-resources)
        System.out.println("\nStream from a file (example skipped, requires file handling).");

        // 9. Creating an empty stream
        Stream<String> emptyStream = Stream.empty();
        System.out.println("\nEmpty Stream:");
        emptyStream.forEach(System.out::println); // No output

        // 10. Creating a stream from a string (split by whitespace)
        String str = "Hello World from Java Streams";
        Stream<String> streamFromString = Arrays.stream(str.split(" "));
        System.out.println("\nStream from String:");
        streamFromString.forEach(System.out::println);

        // 11. Creating a stream from a map (keys)
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        Stream<String> streamFromMapKeys = map.keySet().stream();
        System.out.println("\nStream from Map keys:");
        streamFromMapKeys.forEach(System.out::println);

        // 12. Creating a stream from a map (values)
        Stream<Integer> streamFromMapValues = map.values().stream();
        System.out.println("\nStream from Map values:");
        streamFromMapValues.forEach(System.out::println);

        // 13. Creating a stream from a map (entries)
        Stream<Map.Entry<String, Integer>> streamFromMapEntries = map.entrySet().stream();
        System.out.println("\nStream from Map entries:");
        streamFromMapEntries.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


    }
}