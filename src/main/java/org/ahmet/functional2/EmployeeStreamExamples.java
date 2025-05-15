package org.ahmet.functional2;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamExamples {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Alice", "HR", 50000, 30),
                new Employee(2, "Bob", "IT", 60000, 25),
                new Employee(3, "Charlie", "Finance", 70000, 35),
                new Employee(4, "David", "IT", 80000, 40),
                new Employee(5, "Eve", "HR", 55000, 28),
                new Employee(6, "Frank", "Finance", 75000, 45),
                new Employee(7, "Grace", "IT", 90000, 32),
                new Employee(8, "Heidi", "HR", 52000, 29),
                new Employee(9, "Ivan", "Finance", 72000, 38),
                new Employee(10, "Judy", "IT", 85000, 33),
                new Employee(11, "Mallory", "HR", 53000, 31),
                new Employee(12, "Niaj", "Finance", 78000, 36),
                new Employee(13, "Olivia", "IT", 95000, 29),
                new Employee(14, "Peggy", "HR", 54000, 27),
                new Employee(15, "Rupert", "Finance", 80000, 41)

        );

        // 1. Filter employees by department
        System.out.println("Employees in IT department:");
        employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .forEach(System.out::println);

        // 2. Find the highest-paid employee
        System.out.println("\nHighest-paid employee:");
        employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(System.out::println);

        // 3. Group employees by department
        System.out.println("\nEmployees grouped by department:");
        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(groupedByDepartment);

        // 4. Calculate the average salary of employees
        System.out.println("\nAverage salary:");
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println(averageSalary);

        // 5. Get a list of employee names
        System.out.println("\nList of employee names:");
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(employeeNames);

        // 6. Partition employees by age (above or below 30)
        System.out.println("\nPartition employees by age:");
        Map<Boolean, List<Employee>> partitionedByAge = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 30));
        System.out.println(partitionedByAge);

        // 7. Sort employees by salary
        System.out.println("\nEmployees sorted by salary:");
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .toList();
        sortedBySalary.forEach(System.out::println);

        // 8. Count employees in each department
        System.out.println("\nCount of employees in each department:");
        Map<String, Long> countByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(countByDepartment);

        // 9. Find employees with salary greater than a certain amount
        System.out.println("\nEmployees with salary greater than 60000:");
        employees.stream()
                .filter(e -> e.getSalary() > 60000)
                .forEach(System.out::println);

        // 10. Find the employee with the minimum age
        System.out.println("\nEmployee with minimum age:");
        employees.stream()
                .min(Comparator.comparingInt(Employee::getAge))
                .ifPresent(System.out::println);

        // 11. Find the employee with the maximum age
        System.out.println("\nEmployee with maximum age:");
        employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .ifPresent(System.out::println);

        // 12. Find the total salary of all employees
        System.out.println("\nTotal salary of all employees:");
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(totalSalary);

        // Matching Operations
        System.out.println("\n**Matching Operations**");
        boolean anyIT = employees.stream()
                .anyMatch(e -> e.getDepartment().equals("IT"));
        System.out.println("Any employee in IT department: " + anyIT);

        boolean allHR = employees.stream()
                .allMatch(e -> e.getDepartment().equals("HR"));
        System.out.println("All employees in HR department: " + allHR);

        boolean noneFinance = employees.stream()
                .noneMatch(e -> e.getDepartment().equals("Finance"));
        System.out.println("No employee in Finance department: " + noneFinance);


    }
}