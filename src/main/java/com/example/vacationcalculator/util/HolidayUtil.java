package com.example.vacationcalculator.util;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

public class HolidayUtil {

    private static final Set<LocalDate> HOLIDAYS = new HashSet<>();

    static {
        // Добавьте праздники здесь
        HOLIDAYS.add(LocalDate.of(2023, 1, 1)); // Новый год
        // Добавляйте другие праздники
    }

    public static boolean isHoliday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                date.getDayOfWeek() == DayOfWeek.SUNDAY ||
                HOLIDAYS.contains(date);
    }

    public static long countHolidays(LocalDate startDate, int days) {
        long count = 0;
        LocalDate date = startDate;
        for (int i = 0; i < days; i++) {
            if (isHoliday(date)) {
                count++;
            }
            date = date.plusDays(1);
        }
        return count;
    }
}