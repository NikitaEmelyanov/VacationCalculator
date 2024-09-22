package com.example.vacationcalculator;

import com.example.vacationcalculator.service.VacationCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VacationCalculatorServiceTests {

    private final VacationCalculatorService vacationCalculatorService = new VacationCalculatorService();

    @Test
    public void testCalculateVacationPay() {
        double averageSalary = 60000;
        int vacationDays = 14;
        LocalDate startDate = LocalDate.of(2023, 7, 1);

        double result = vacationCalculatorService.calculateVacationPay(averageSalary, vacationDays, startDate);
        // При необходимости скорректируйте ожидаемый результат
        double expected = (averageSalary / 29.3) * (vacationDays - 4); // Учтем примерное количество праздников и выходных

        assertEquals(expected, result, 0.01);
    }
}