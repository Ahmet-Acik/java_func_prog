package org.ahmet.functional2;

import java.util.Optional;

public class OptionalDemoIntro {
    public static void main(String[] args) {

        // Step 1: Create an Optional
        Optional<String> greetingOptional = Optional.of("Hello, Optional!");

        // Step 2: Check if a value is present
        if (greetingOptional.isPresent()) {
            System.out.println("Value is present: " + greetingOptional.get());
        }

        // Step 3: Safely transform the value
        greetingOptional.map(String::toUpperCase)
                .ifPresent(transformedValue -> System.out.println("Transformed value: " + transformedValue));

        // Step 4: Provide a default value if empty
        String fallbackValue = greetingOptional.orElse("Default Value");
        System.out.println("Value or default: " + fallbackValue);


        String nonOptionalValue = "Hello, World!";

        // Wrap using Optional.of (if non-null)
        Optional<String> optionalValue = Optional.of(nonOptionalValue);

        // Wrap using Optional.ofNullable (if it might be null)
        String nullableValue = null;
        Optional<String> optionalNullableValue = Optional.ofNullable(nullableValue);

        // Safely handle the Optional
        optionalValue.ifPresent(value -> System.out.println("Value: " + value));
        optionalNullableValue.ifPresentOrElse(
                value -> System.out.println("Nullable Value: " + value),
                () -> System.out.println("Value is absent")
        );

    }
}