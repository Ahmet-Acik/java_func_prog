package org.ahmet.functional2;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

        // 7. orElseGet
        String valueUsingOrElseGet = emptyOptional.orElseGet(() -> "Generated Default Value");
        System.out.println("Value using orElseGet: " + valueUsingOrElseGet);

        // 8. orElseThrow
        try {
            String valueUsingOrElseThrow = emptyOptional.orElseThrow(() -> new IllegalArgumentException("Value is not present!"));
            System.out.println("Value using orElseThrow: " + valueUsingOrElseThrow);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // 9. filter
        Optional<String> filteredValue = optionalValue.filter(value -> value.startsWith("Hello"));
        filteredValue.ifPresent(value -> System.out.println("Filtered value: " + value));

        // 10. isEmpty (Java 11+)
        if (emptyOptional.isEmpty()) {
            System.out.println("The optional is empty.");
        } else {
            System.out.println("The optional is not empty.");
        }

        // 1. Using Function with Optional.map
        Optional<String> optionalValue2 = Optional.of("Hello, Functional Interfaces!");
        Function<String, Integer> lengthFunction = String::length;
        Optional<Integer> lengthOptional2 = optionalValue2.map(lengthFunction);
        lengthOptional2.ifPresent(length -> System.out.println("Length of the string: " + length));

        // 2. Using Consumer with Optional.ifPresent
        Consumer<String> printConsumer = System.out::println;
        optionalValue2.ifPresent(printConsumer);

        // 3. Using Supplier with Optional.orElseGet
        Supplier<String> defaultSupplier = () -> "Default Value from Supplier";
        String value = Optional.<String>empty().orElseGet(defaultSupplier);
        System.out.println("Value using Supplier: " + value);

        // 4. Using Predicate with Optional.filter
        Predicate<String> startsWithPredicate = str -> str.startsWith("Hello");
        Optional<String> filteredValue2 = optionalValue2.filter(startsWithPredicate);
        filteredValue2.ifPresent(val -> System.out.println("Filtered value: " + val));

    }
}