package org.ahmet.functional1;

// Custom functional interface
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        // Example 1: Using a lambda with a custom functional interface
        Greeting greeting = name -> System.out.println("Hello, " + name + "!");
        greeting.sayHello("Ahmet");

        // Example 2: Replacing an anonymous class with a lambda
        Runnable task = () -> System.out.println("Task executed using a lambda!");
        task.run();

        // Example 3: Using a built-in functional interface
        java.util.function.Function<String, Integer> stringLength = str -> str.length();
        System.out.println("Length of 'Functional': " + stringLength.apply("Functional"));
    }
}