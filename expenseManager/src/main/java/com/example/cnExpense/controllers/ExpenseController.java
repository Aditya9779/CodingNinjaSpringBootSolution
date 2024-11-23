package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // POST "/expenses/save/{incomeId}": Create a new expense for the given incomeId
    @PostMapping("/save/{incomeId}")
    public Income /*Expense*/ saveExpense(@PathVariable Integer incomeId, @RequestBody Expense expense) {
        return expenseService.saveExpense(incomeId, expense);
    }
}