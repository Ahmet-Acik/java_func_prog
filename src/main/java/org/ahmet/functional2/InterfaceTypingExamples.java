package org.ahmet.functional2;

public class InterfaceTypingExamples {
    public static void main(String[] args) {
        // 1. Lambdas vs Anonymous Classes
        System.out.println("**Lambdas vs Anonymous Classes**");

        // Anonymous class example
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running with an anonymous class!");
            }
        };
        anonymousRunnable.run();

        // Lambda example
        Runnable lambdaRunnable = () -> System.out.println("Running with a lambda!");
        lambdaRunnable.run();

        // 2. The Functional Interface Annotation
        System.out.println("\n**The Functional Interface Annotation**");
        System.out.println("Ensures the interface has exactly one abstract method.");
        ExampleFunctionalInterface example = () -> System.out.println("Functional interface with @FunctionalInterface!");
        example.execute();

        // 3. The Interface Overhead of Lambdas
        System.out.println("\n**The Interface Overhead of Lambdas**");
        System.out.println("Lambdas are converted to instances of functional interfaces at runtime.");
        System.out.println("This adds a small overhead compared to direct method calls.");
    }

    @FunctionalInterface
    interface ExampleFunctionalInterface {
        void execute();
    }
}