package org.ahmet;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileIOExamples {
    public static void main(String[] args) {
        Path filePath = Paths.get("example.txt");
        Path directoryPath = Paths.get("exampleDir");

        try {
            // Example 1: Writing to a file
            Files.write(filePath, "Hello, File I/O!".getBytes());
            System.out.println("File written: " + filePath);

            // Example 2: Reading from a file
            List<String> lines = Files.readAllLines(filePath);
            System.out.println("File content: " + lines);

            // Example 3: Creating a directory
            if (!Files.exists(directoryPath)) {
                Files.createDirectory(directoryPath);
                System.out.println("Directory created: " + directoryPath);
            }

            // Example 4: Listing directory contents
            Files.list(directoryPath).forEach(System.out::println);

            // Example 5: Deleting a file and directory
            Files.delete(filePath);
            System.out.println("File deleted: " + filePath);

            Files.delete(directoryPath);
            System.out.println("Directory deleted: " + directoryPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}