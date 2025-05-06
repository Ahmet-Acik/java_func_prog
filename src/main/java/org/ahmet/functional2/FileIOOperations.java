package org.ahmet.functional2;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileIOOperations {
    public static void main(String[] args) {
        Path directoryPath = Paths.get("exampleDir");
        Path filePath = directoryPath.resolve("exampleFile.txt");
        Path sourceFile = directoryPath.resolve("sourceFile.txt");
        Path targetFile = directoryPath.resolve("targetFile.txt");
        Path targetDir = Paths.get("exampleDirCopy");
        Path movedDir = Paths.get("exampleDirMoved");

        try {
            // Cleanup: Delete existing directories and files
            deleteIfExistsRecursively(movedDir);
            deleteIfExistsRecursively(targetDir);
            deleteIfExistsRecursively(directoryPath);

            // 1. Create a directory
            if (!Files.exists(directoryPath)) {
                Files.createDirectory(directoryPath);
                System.out.println("Directory created: " + directoryPath);
            }

            // 2. Create a file
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
                System.out.println("File created: " + filePath);
            }

            // 3. Write to a file
            List<String> lines = List.of("Line 1", "Line 2", "Line 3");
            Files.write(filePath, lines, StandardOpenOption.WRITE);
            System.out.println("Data written to file: " + filePath);

            // 4. Read from a file
            List<String> readLines = Files.readAllLines(filePath);
            System.out.println("Data read from file:");
            readLines.forEach(System.out::println);

            // 5. Copy a file
            if (Files.exists(filePath)) {
                Files.copy(filePath, sourceFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File copied from " + filePath + " to " + sourceFile);
            }

            // 6. Move (or rename) a file
            if (Files.exists(sourceFile)) {
                Files.move(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File moved/renamed to " + targetFile);
            }

            // 7. Copy a directory
            if (Files.exists(directoryPath)) {
                Files.walk(directoryPath).forEach(source -> {
                    try {
                        Path destination = targetDir.resolve(directoryPath.relativize(source));
                        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.err.println("Error copying directory: " + e.getMessage());
                    }
                });
                System.out.println("Directory copied from " + directoryPath + " to " + targetDir);
            }

            // 8. Move a directory
            if (Files.exists(targetDir)) {
                Files.move(targetDir, movedDir, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Directory moved to " + movedDir);
            }

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static void deleteIfExistsRecursively(Path path) throws IOException {
        if (Files.exists(path)) {
            Files.walk(path)
                .sorted((path1, path2) -> path2.compareTo(path1)) // Delete children before parent
                .forEach(p -> {
                    try {
                        Files.delete(p);
                    } catch (IOException e) {
                        System.err.println("Failed to delete " + p + ": " + e.getMessage());
                    }
                });
        }
    }
}