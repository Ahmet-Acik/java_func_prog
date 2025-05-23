package org.ahmet;

import java.util.Optional;

public class OptionalExamples {
    public static void main(String[] args) {
        // Example 1: Creating Optional objects
        Optional<String> nonEmptyOptional = Optional.of("Hello, Optional!");
        Optional<String> emptyOptional = Optional.empty();
        Optional<String> nullableOptional = Optional.ofNullable(null);

        // Example 2: Checking presence
        System.out.println("Is nonEmptyOptional present? " + nonEmptyOptional.isPresent());
        System.out.println("Is emptyOptional present? " + emptyOptional.isPresent());

        // Example 3: Using ifPresent
        nonEmptyOptional.ifPresent(value -> System.out.println("Value: " + value));

        // Example 4: Providing a default value
        String defaultValue = emptyOptional.orElse("Default Value");
        System.out.println("Default value: " + defaultValue);

        // Example 5: Transforming value with map
        Optional<Integer> lengthOptional = nonEmptyOptional.map(String::length);
        lengthOptional.ifPresent(length -> System.out.println("Length: " + length));

        // Example 6: Chaining with flatMap
        Optional<String> upperCaseOptional = nonEmptyOptional.flatMap(value -> Optional.of(value.toUpperCase()));
        upperCaseOptional.ifPresent(value -> System.out.println("Uppercase: " + value));
    }
}