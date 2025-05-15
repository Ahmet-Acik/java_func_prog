package org.ahmet.functional2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {
        // 1. Streams vs Collections
        System.out.println("**Streams vs Collections**");
        List<Integer> collection = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println("Collection before modification: " + collection);
        collection.add(6); // Collections are mutable
        System.out.println("Collection after modification: " + collection);

        Stream<Integer> stream = collection.stream();
        System.out.println("Stream cannot be modified after creation.");
        System.out.println("Stream elements: " + stream.toList());

        // 2. Limit and Filter Operators
        System.out.println("\n**Limit and Filter Operators**");
        List<Integer> limitedFiltered = IntStream.range(1, 20)
                                                 .filter(x -> x % 2 == 0) // Filter even numbers
                                                 .limit(5) // Limit to first 5 elements
                                                 .boxed()
                                                 .toList();
        System.out.println("Limited and filtered numbers: " + limitedFiltered);

        // 3. The Map Operator
        System.out.println("\n**The Map Operator**");
        List<String> mapped = List.of("apple", "banana", "cherry").stream()
                                  .map(String::toUpperCase) // Convert to uppercase
                                  .toList();
        System.out.println("Mapped strings: " + mapped);

        // 4. The Peek Operator and Debugging
        System.out.println("\n**The Peek Operator and Debugging**");
        List<Integer> peeked = IntStream.range(1, 6)
                                        .peek(x -> System.out.println("Processing: " + x)) // Debug intermediate values
                                        .map(x -> x * x) // Square each number
                                        .boxed()
                                        .toList();
        System.out.println("Peeked numbers: " + peeked);

        // 5. The Effect of Terminal Operations
        System.out.println("\n**The Effect of Terminal Operations**");
        Stream<Integer> infiniteStream = Stream.iterate(1, n -> n + 1);
        List<Integer> firstTen = infiniteStream.limit(10).toList(); // Terminal operation triggers processing
        System.out.println("First 10 numbers from infinite stream: " + firstTen);

        // 6. Distinct and Sorted Operators
        System.out.println("\n**Distinct and Sorted Operators**");
        List<Integer> distinctSorted = Stream.of(5, 3, 1, 2, 3, 4, 5)
                                             .distinct() // Remove duplicates
                                             .sorted() // Sort the elements
                                             .toList();
        System.out.println("Distinct and sorted numbers: " + distinctSorted);

        // 7. Concatenating Streams
        System.out.println("\n**Concatenating Streams**");
        Stream<String> stream1 = Stream.of("A", "B", "C");
        Stream<String> stream2 = Stream.of("D", "E", "F");
        List<String> concatenated = Stream.concat(stream1, stream2) // Concatenate two streams
                                          .toList();
        System.out.println("Concatenated streams: " + concatenated);

        // 8. Working with Object Streams
        System.out.println("\n**Working with Object Streams**");
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

        List<Person> people = List.of(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
        );

        List<String> names = people.stream()
                                   .map(person -> person.name) // Extract names
                                   .toList();
        System.out.println("Names of people: " + names);

        List<Person> sortedByAge = people.stream()
                                         .sorted((p1, p2) -> Integer.compare(p1.age, p2.age)) // Sort by age
                                         .toList();
        System.out.println("People sorted by age: " + sortedByAge);
    }
}