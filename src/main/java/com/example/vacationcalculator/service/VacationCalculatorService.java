package com.example.vacationcalculator.service;

import com.example.vacationcalculator.util.HolidayUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VacationCalculatorService {

    public double calculateVacationPay(double averageSalary, int vacationDays, LocalDate startDate) {
        long holidayCount = HolidayUtil.countHolidays(startDate, vacationDays);
        int actualWorkingDays = vacationDays - (int) holidayCount;

        return averageSalary / 29.3 * actualWorkingDays;
    }
}