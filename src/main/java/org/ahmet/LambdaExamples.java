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
    }
}