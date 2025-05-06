package org.ahmet.functional2;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // 1. Creating Optional objects
        Optional<String> optionalValue = Optional.of("Hello, Optional!");
        Optional<String> emptyOptional = Optional.empty();

        // 2. isPresent
        if (optionalValue.isPresent()) {
            System.out.println("Value is present: " + optionalValue.get());
        } else {
            System.out.println("Value is not present.");
        }

        // 3. ifPresent
        optionalValue.ifPresent(value -> System.out.println("Value using ifPresent: " + value));

        // 4. orElse
        String defaultValue = emptyOptional.orElse("Default Value");
        System.out.println("Value using orElse: " + defaultValue);

        // 5. map
        Optional<Integer> lengthOptional = optionalValue.map(String::length);
        lengthOptional.ifPresent(length -> System.out.println("Length of the string: " + length));

        // 6. flatMap
        Optional<String> flatMappedValue = optionalValue.flatMap(value -> Optional.of(value.toUpperCase()));
        flatMappedValue.ifPresent(value -> System.out.println("FlatMapped value: " + value));


    }
}