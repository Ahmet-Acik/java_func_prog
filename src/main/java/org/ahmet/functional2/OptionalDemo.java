package org.ahmet.functional2;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        // Step 1: Create an Optional
        Optional<String> optionalValue = Optional.of("Hello, Optional!");

        // Step 2: Check if a value is present
        if (optionalValue.isPresent()) {
            System.out.println("Value is present: " + optionalValue.get());
        }

        // Step 3: Safely transform the value
        optionalValue.map(String::toUpperCase)
                     .ifPresent(value -> System.out.println("Transformed value: " + value));

        // Step 4: Provide a default value if empty
        String defaultValue = optionalValue.orElse("Default Value");
        System.out.println("Value or default: " + defaultValue);
    }
}