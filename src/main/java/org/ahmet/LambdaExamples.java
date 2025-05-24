package org.ahmet;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaExamples {
    public static void main(String[] args) {
        // Example 1: Runnable with lambda
        Runnable task = () -> System.out.println("Executing a task using a lambda expression!");
        task.run();

        // Example 2: Comparator with lambda
        String[] names = {"Ahmet", "John", "Zara", "Emily"};
        Arrays.sort(names, (a, b) -> a.compareToIgnoreCase(b));
        System.out.println("Sorted names (case-insensitive): " + Arrays.toString(names));

        // Example 3: Comparator with a more readable lambda
        Arrays.sort(names, Comparator.comparing(String::toLowerCase));
        System.out.println("Sorted names (using Comparator.comparing): " + Arrays.toString(names));

        // Example 4: Using a lambda to calculate the length of strings
        Arrays.stream(names)
              .map(name -> "Name: " + name + ", Length: " + name.length())
              .forEach(System.out::println);

        // Example 5: Using a lambda to filter names starting with 'A'
        String[] filteredNames = Arrays.stream(names)
                                       .filter(name -> name.startsWith("A"))
                                       .toArray(String[]::new);
        System.out.println("Names starting with 'A': " + Arrays.toString(filteredNames));

        // Example 6: Using a lambda to find the first name that contains 'e'
        String firstWithE = Arrays.stream(names)
                                  .filter(name -> name.contains("e"))
                                  .findFirst()
                                  .orElse("No name found containing 'e'");
        System.out.println("First name containing 'e': " + firstWithE);

        // Example 7: Using a lambda to print names in uppercase
        System.out.println("Names in uppercase:");
        Arrays.stream(names)
              .map(String::toUpperCase)
              .forEach(System.out::println);

        // Example 8: Using a lambda to create a custom message for each name
        Arrays.stream(names)
              .map(name -> "Hello, " + name + "!")
              .forEach(System.out::println);

        // Example 9: Using a lambda to sort names by length
        Arrays.sort(names, Comparator.comparingInt(String::length));
        System.out.println("Sorted names by length: " + Arrays.toString(names));

        // Example 10: Using a lambda to create a list of name lengths
        int[] nameLengths = Arrays.stream(names)
                                  .mapToInt(String::length)
                                  .toArray();
        System.out.println("Lengths of names: " + Arrays.toString(nameLengths));

        // Example 11: Using a lambda to find the longest name
        String longestName = Arrays.stream(names)
                .max(Comparator.comparingInt(String::length))
                .orElse("No names available");
        System.out.println("Longest name: " + longestName);

    }
}