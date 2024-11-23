package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.Income;
import com.example.cnExpense.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    // GET "/incomes/{incomeid}": Retrieve income by ID
    @GetMapping("/{incomeid}")
    public Income getIncomeById(@PathVariable Integer incomeid) {
        return incomeService.getIncomeById(incomeid);
    }

    // POST "/incomes/save/{userId}": Register a new income for the given userId
    @PostMapping("/save/{userId}")
    public Income saveIncome(@PathVariable Integer userId, @RequestBody Income income) {
        return incomeService.saveIncome(userId, income);
    }
}