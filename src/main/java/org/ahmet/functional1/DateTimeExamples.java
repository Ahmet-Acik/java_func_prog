package org.ahmet.functional1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExamples {
    public static void main(String[] args) {
        // Example 1: Current date, time, and datetime
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current date: " + currentDate);
        System.out.println("Current time: " + currentTime);
        System.out.println("Current datetime: " + currentDateTime);

        // Example 2: Formatting and parsing
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Formatted datetime: " + formattedDateTime);

        LocalDateTime parsedDateTime = LocalDateTime.parse("25-12-2023 15:30:00", formatter);
        System.out.println("Parsed datetime: " + parsedDateTime);

        // Example 3: Date and time arithmetic
        LocalDate nextWeek = currentDate.plusWeeks(1);
        LocalTime twoHoursLater = currentTime.plusHours(2);
        LocalDateTime nextMonth = currentDateTime.plusMonths(1);
        System.out.println("Date next week: " + nextWeek);
        System.out.println("Time two hours later: " + twoHoursLater);
        System.out.println("Datetime next month: " + nextMonth);
    }
}