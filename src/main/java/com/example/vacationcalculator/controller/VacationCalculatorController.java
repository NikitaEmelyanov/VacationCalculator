package com.example.vacationcalculator.controller;

import com.example.vacationcalculator.model.VacationRequest;
import com.example.vacationcalculator.service.VacationCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculate")
public class VacationCalculatorController {

    private final VacationCalculatorService vacationCalculatorService;

    @Autowired
    public VacationCalculatorController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    @PostMapping
    public double calculateVacationPay(@RequestBody VacationRequest request) {
        return vacationCalculatorService.calculateVacationPay(
                request.getAverageSalary(),
                request.getVacationDays(),
                request.getStartDate()
        );
    }
}