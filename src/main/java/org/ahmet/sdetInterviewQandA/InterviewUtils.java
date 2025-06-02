package org.ahmet.sdetInterviewQandA;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility class for common interview coding tasks.
 */
public class InterviewUtils {

    /**
     * Removes duplicate characters from a string.
     *
     * @param input the input string
     * @return a string with duplicates removed
     */
    public static String removeDuplicates(String input) {
        return input.chars()
                    .distinct()
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining());
    }

    /**
     * Generates all substrings of a given string.
     *
     * @param input the input string
     * @return a list of all substrings
     */
    public static List<String> findAllSubstrings(String input) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                substrings.add(input.substring(i, j));
            }
        }
        return substrings;
    }

    /**
     * Finds the missing number in an array of integers from 1 to n.
     *
     * @param numbers the array of integers
     * @param n       the range limit
     * @return the missing number
     */
    public static int findMissingNumber(int[] numbers, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(numbers).sum();
        return expectedSum - actualSum;
    }

    /**
     * Rotates an array to the right by k positions.
     *
     * @param arr the input array
     * @param k   the number of positions to rotate
     * @return the rotated array
     */
    public static int[] rotateArray(int[] arr, int k) {
        int n = arr.length;
        k %= n;
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = arr[i];
        }
        return rotated;
    }

    /**
     * Checks if a number is prime.
     *
     * @param num the number to check
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                        .noneMatch(i -> num % i == 0);
    }

    /**
     * Generates the first n numbers of the Fibonacci sequence.
     *
     * @param n the number of Fibonacci numbers to generate
     * @return a list of Fibonacci numbers
     */
    public static List<Integer> generateFibonacci(int n) {
        List<Integer> fibonacci = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            fibonacci.add(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
        return fibonacci;
    }

    /**
     * Finds duplicate elements in a list.
     *
     * @param numbers the list of integers
     * @return a list of duplicate elements
     */
    public static List<Integer> findDuplicates(List<Integer> numbers) {
        return numbers.stream()
                      .filter(n -> Collections.frequency(numbers, n) > 1)
                      .distinct()
                      .toList();
    }

    /**
     * Finds the top N largest elements in a list.
     *
     * @param numbers the list of integers
     * @param n       the number of top elements to find
     * @return a list of top N elements
     */
    public static List<Integer> findTopNElements(List<Integer> numbers, int n) {
        return numbers.stream()
                      .sorted(Comparator.reverseOrder())
                      .limit(n)
                      .toList();
    }

    /**
     * Finds the depth of a binary tree.
     *
     * @param root the root of the binary tree
     * @return the depth of the tree
     */
    public static int findTreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(findTreeDepth(root.left), findTreeDepth(root.right));
    }

    /**
     * Checks if a graph is connected using DFS.
     *
     * @param graph     the adjacency list representation of the graph
     * @param startNode the starting node
     * @return true if the graph is connected, false otherwise
     */
    public static boolean isGraphConnected(Map<Integer, List<Integer>> graph, int startNode) {
        Set<Integer> visited = new HashSet<>();
        dfs(graph, startNode, visited);
        return visited.size() == graph.size();
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        if (!visited.contains(node)) {
            visited.add(node);
            for (int neighbor : graph.get(node)) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}