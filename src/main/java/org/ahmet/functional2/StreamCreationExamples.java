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


    }
}