package org.ahmet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollectorsExamples {
    public static void main(String[] args) {
        // Example 1: Custom collector to join strings with a delimiter
        List<String> names = Arrays.asList("Ahmet", "John", "Zara", "Emily");
        String joinedNames = names.stream()
                                  .collect(Collector.of(
                                      StringBuilder::new,
                                      (sb, s) -> sb.append(s).append(", "),
                                      StringBuilder::append,
                                      sb -> sb.substring(0, sb.length() - 2)
                                  ));
        System.out.println("Joined names: " + joinedNames);

        // Example 2: Using Collectors.reducing for advanced reduction
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int product = numbers.stream()
                             .collect(Collectors.reducing(1, (a, b) -> a * b));
        System.out.println("Product of numbers: " + product);
    }
}