package org.ahmet.functional1;

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

        // Example 7: Handling absence with orElseThrow
        try {
            String value = nullableOptional.orElseThrow(() -> new IllegalArgumentException("Value is absent!"));
            System.out.println("Value: " + value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Example 8: Using filter to conditionally keep values
        Optional<String> filteredOptional = nonEmptyOptional.filter(value -> value.length() > 10);
        filteredOptional.ifPresent(value -> System.out.println("Filtered value: " + value));


        // Example 9: Using orElseGet to provide a value from a supplier
        String valueFromSupplier = emptyOptional.orElseGet(() -> "Value from Supplier");
        System.out.println("Value from supplier: " + valueFromSupplier);

        // Example 10: Using or to provide an alternative Optional
        Optional<String> alternativeOptional = emptyOptional.or(() -> Optional.of("Alternative Value"));
        alternativeOptional.ifPresent(value -> System.out.println("Alternative value: " + value));


    }
}