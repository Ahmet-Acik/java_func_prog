package org.ahmet.sdetInterviewQandA;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class for additional interview coding tasks.
 */
public class AdditionalInterviewQuestions {

    public static String removeDuplicates(String input) {
        return input.chars()
                    .distinct()
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining());
    }

    public static List<String> findAllSubstrings(String input) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                substrings.add(input.substring(i, j));
            }
        }
        return substrings;
    }

    public static int findMissingNumber(int[] numbers, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(numbers).sum();
        return expectedSum - actualSum;
    }

    public static int[] rotateArray(int[] arr, int k) {
        int n = arr.length;
        k %= n;
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = arr[i];
        }
        return rotated;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

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

    public static List<Integer> findDuplicates(List<Integer> numbers) {
        return numbers.stream()
                      .filter(n -> Collections.frequency(numbers, n) > 1)
                      .distinct()
                      .toList();
    }

    public static List<Integer> findTopNElements(List<Integer> numbers, int n) {
        return numbers.stream()
                      .sorted(Comparator.reverseOrder())
                      .limit(n)
                      .toList();
    }

    public static int findTreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(findTreeDepth(root.left), findTreeDepth(root.right));
    }

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

    public static void main(String[] args) {
        System.out.println(removeDuplicates("Ahmet"));
        System.out.println(findAllSubstrings("Ahmet"));
        System.out.println(findMissingNumber(new int[]{1, 2, 4, 5}, 5));
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(isPrime(7));
        System.out.println(generateFibonacci(10));
        System.out.println(findDuplicates(Arrays.asList(1, 2, 3, 2, 4, 5, 1)));
        System.out.println(findTopNElements(Arrays.asList(1, 2, 3, 4, 5), 3));
    }
}