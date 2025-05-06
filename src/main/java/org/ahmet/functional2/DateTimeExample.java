package org.ahmet.functional2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeExample {
    public static void main(String[] args) {
        // 1. LocalDate: Represents a date without time
        LocalDate today = LocalDate.now(); // Current date
        LocalDate specificDate = LocalDate.of(2023, Month.OCTOBER, 15); // Specific date
        System.out.println("Today: " + today);
        System.out.println("Specific Date: " + specificDate);

        // 2. LocalTime: Represents a time without date
        LocalTime now = LocalTime.now(); // Current time
        LocalTime specificTime = LocalTime.of(14, 30, 15); // Specific time
        System.out.println("Current Time: " + now);
        System.out.println("Specific Time: " + specificTime);

        // 3. LocalDateTime: Combines date and time
        LocalDateTime currentDateTime = LocalDateTime.now(); // Current date and time
        LocalDateTime specificDateTime = LocalDateTime.of(2023, Month.OCTOBER, 15, 14, 30, 15); // Specific date and time
        System.out.println("Current DateTime: " + currentDateTime);
        System.out.println("Specific DateTime: " + specificDateTime);

        // 4. Formatting dates and times
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Formatted Date: " + today.format(dateFormatter));
        System.out.println("Formatted Time: " + now.format(timeFormatter));
        System.out.println("Formatted DateTime: " + currentDateTime.format(dateTimeFormatter));

        // 5. Parsing dates and times
        LocalDate parsedDate = LocalDate.parse("15-10-2023", dateFormatter); // Parse string to LocalDate
        LocalTime parsedTime = LocalTime.parse("14:30:15", timeFormatter); // Parse string to LocalTime
        LocalDateTime parsedDateTime = LocalDateTime.parse("15-10-2023 14:30:15", dateTimeFormatter); // Parse string to LocalDateTime
        System.out.println("Parsed Date: " + parsedDate);
        System.out.println("Parsed Time: " + parsedTime);
        System.out.println("Parsed DateTime: " + parsedDateTime);

        // 6. Date arithmetic
        LocalDate tomorrow = today.plusDays(1); // Add 1 day
        LocalDate lastWeek = today.minusWeeks(1); // Subtract 1 week
        LocalTime oneHourLater = now.plusHours(1); // Add 1 hour
        LocalDateTime nextMonth = currentDateTime.plusMonths(1); // Add 1 month
        System.out.println("Tomorrow: " + tomorrow);
        System.out.println("Last Week: " + lastWeek);
        System.out.println("One Hour Later: " + oneHourLater);
        System.out.println("Next Month: " + nextMonth);

        // 7. Difference between dates and times
        long daysBetween = ChronoUnit.DAYS.between(specificDate, today); // Days between two dates
        long hoursBetween = ChronoUnit.HOURS.between(specificDateTime, currentDateTime); // Hours between two date-times
        System.out.println("Days Between Specific Date and Today: " + daysBetween);
        System.out.println("Hours Between Specific DateTime and Current DateTime: " + hoursBetween);
    }
}