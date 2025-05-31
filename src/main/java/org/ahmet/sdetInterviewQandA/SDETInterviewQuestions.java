package org.ahmet.sdetInterviewQandA;

import java.util.*;
import java.util.stream.Collectors;

public class SDETInterviewQuestions {

    // Reverse a string
    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    // Find the second largest number in an array
    public static int findSecondLargest(int[] numbers) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    // Check if a string is a palindrome
    public static boolean isPalindrome(String input) {
        int left = 0, right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Filter even numbers from a list using streams
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .filter(n -> n % 2 == 0)
                      .collect(Collectors.toList());
    }

    // Group strings by their length using streams
    public static Map<Integer, List<String>> groupByLength(List<String> strings) {
        return strings.stream()
                      .collect(Collectors.groupingBy(String::length));
    }

    // Count character frequency in a string
    public static Map<Character, Integer> countCharacterFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    // Find the longest word in a sentence
    public static String findLongestWord(String sentence) {
        return Arrays.stream(sentence.split(" "))
                     .max(Comparator.comparingInt(String::length))
                     .orElse("");
    }

    // Find the maximum number in a list
    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                      .max(Integer::compareTo)
                      .orElseThrow(() -> new RuntimeException("No maximum found"));
    }

    // Find the minimum number in a list
    public static int findMinNumber(List<Integer> numbers) {
        return numbers.stream()
                      .min(Integer::compareTo)
                      .orElseThrow(() -> new RuntimeException("No minimum found"));
    }

    // Check if all numbers are positive
    public static boolean allNumbersPositive(List<Integer> numbers) {
        return numbers.stream()
                      .allMatch(n -> n > 0);
    }

    // Check if any number is even
    public static boolean anyNumberEven(List<Integer> numbers) {
        return numbers.stream()
                      .anyMatch(n -> n % 2 == 0);
    }

    // Check if no number is negative
    public static boolean noNumberNegative(List<Integer> numbers) {
        return numbers.stream()
                      .noneMatch(n -> n < 0);
    }

    // Join names into a single string
    public static String joinNames(List<String> names) {
        return names.stream()
                    .collect(Collectors.joining(", "));
    }

    // Count the number of names
    public static long countNames(List<String> names) {
        return names.stream()
                    .count();
    }

    // Write a custom message for each name
    public static List<String> createCustomMessages(List<String> names) {
        return names.stream()
                    .map(name -> "Hello, " + name + "!")
                    .collect(Collectors.toList());
    }

    // Sort names by length
    public static List<String> sortNamesByLength(List<String> names) {
        return names.stream()
                    .sorted(Comparator.comparingInt(String::length))
                    .collect(Collectors.toList());
    }

    // Find the longest name
    public static String findLongestName(List<String> names) {
        return names.stream()
                    .max(Comparator.comparingInt(String::length))
                    .orElse("No names available");
    }



    // Example usage
    public static void main(String[] args) {
        // Test methods here
        System.out.println(reverseString("Ahmet"));
        System.out.println(findSecondLargest(new int[]{1, 2, 3, 4, 5}));
        System.out.println(isPalindrome("madam"));
        System.out.println(filterEvenNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        System.out.println(groupByLength(Arrays.asList("Ahmet", "John", "Zara", "Emily")));
        System.out.println(countCharacterFrequency("Ahmet"));
        System.out.println(findLongestWord("Ahmet loves coding"));
        System.out.println(findMaxNumber(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(findMinNumber(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(allNumbersPositive(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(anyNumberEven(Arrays.asList(1, 3, 5, 7, 9)));
        System.out.println(noNumberNegative(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(joinNames(Arrays.asList("Ahmet", "John", "Zara", "Emily")));
        System.out.println(countNames(Arrays.asList("Ahmet", "John", "Zara", "Emily")));
        System.out.println(createCustomMessages(Arrays.asList("Ahmet", "John", "Zara", "Emily")));
        System.out.println(sortNamesByLength(Arrays.asList("Ahmet", "John", "Zara", "Emily")));
        System.out.println(findLongestName(Arrays.asList("Ahmet", "John", "Zara", "Emily")));
    }
}