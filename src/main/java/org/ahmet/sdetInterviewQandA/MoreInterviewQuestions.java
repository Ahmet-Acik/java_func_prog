package org.ahmet.sdetInterviewQandA;

import java.util.*;
import java.util.stream.Collectors;

public class MoreInterviewQuestions {

    // Check if a string contains only digits
    public static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    // Find the first non-repeating character in a string
    public static Character findFirstNonRepeatingCharacter(String input) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap.entrySet().stream()
                           .filter(entry -> entry.getValue() == 1)
                           .map(Map.Entry::getKey)
                           .findFirst()
                           .orElse(null);
    }

    // Check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // Find the intersection of two arrays
    public static int[] findArrayIntersection(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1)
                     .filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x))
                     .distinct()
                     .toArray();
    }

    // Find the union of two arrays
    public static int[] findArrayUnion(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1)
                     .flatMap(x -> Arrays.stream(arr2).filter(y -> y == x))
                     .distinct()
                     .toArray();
    }

    // Check if a number is a perfect square
    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    // Find the factorial of a number
    public static long findFactorial(int num) {
        if (num < 0) throw new IllegalArgumentException("Number must be non-negative");
        return num == 0 ? 1 : num * findFactorial(num - 1);
    }

    // Find the GCD of two numbers
    public static int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);
    }

    // Find the LCM of two numbers
    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(isNumeric("12345"));
        System.out.println(findFirstNonRepeatingCharacter("swiss"));
        System.out.println(areAnagrams("listen", "silent"));
        System.out.println(Arrays.toString(findArrayIntersection(new int[]{1, 2, 3}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(findArrayUnion(new int[]{1, 2, 3}, new int[]{3, 4, 5})));
        System.out.println(isPerfectSquare(16));
        System.out.println(findFactorial(5));
        System.out.println(findGCD(12, 15));
        System.out.println(findLCM(12, 15));
    }
}