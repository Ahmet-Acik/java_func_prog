package org.ahmet.functional2;

import java.util.Optional;
import java.util.List;
import java.util.Map;

public class OptionalDemo {
    public static void main(String[] args) {

        // Example 1: Optional with Integer
        Optional<Integer> numberOptional = Optional.of(42);
        numberOptional.map(num -> num * 2)
                .ifPresent(doubled -> System.out.println("Doubled value: " + doubled));
        Integer fallbackNumber = numberOptional.orElse(0);
        System.out.println("Number or default: " + fallbackNumber);

        // Example 2: Optional with List
        List<String> names = List.of("Alice", "Bob", "Charlie");
        Optional<List<String>> namesOptional = Optional.of(names);
        namesOptional.ifPresent(list -> System.out.println("Names: " + list));
        List<String> fallbackList = namesOptional.orElse(List.of("Default Name"));
        System.out.println("Names or default: " + fallbackList);

        // Example 3: Optional with Map
        Map<String, Integer> ageMap = Map.of("Alice", 30, "Bob", 25);
        Optional<Map<String, Integer>> ageMapOptional = Optional.of(ageMap);
        ageMapOptional.ifPresent(map -> System.out.println("Ages: " + map));
        Map<String, Integer> fallbackMap = ageMapOptional.orElse(Map.of("Default", 0));
        System.out.println("Ages or default: " + fallbackMap);

        // Example 4: Optional with Double
        Double nullableDouble = null;
        Optional<Double> doubleOptional = Optional.ofNullable(nullableDouble);
        doubleOptional.ifPresentOrElse(
                value -> System.out.println("Double value: " + value),
                () -> System.out.println("Double value is absent")
        );
        Double fallbackDouble = doubleOptional.orElse(0.0);
        System.out.println("Double or default: " + fallbackDouble);

        // Example 5: Optional with Custom Object

        class Person {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return name + " (" + age + ")";
            }
        }

        Person person = new Person("John", 28);
        Optional<Person> personOptional = Optional.of(person);
        personOptional.map(p -> p.name.toUpperCase())
                .ifPresent(name -> System.out.println("Uppercase name: " + name));
        Person fallbackPerson = personOptional.orElse(new Person("Default", 0));
        System.out.println("Person or default: " + fallbackPerson);
    }
}