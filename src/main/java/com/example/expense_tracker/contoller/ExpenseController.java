package com.example.expense_tracker.contoller;

import com.example.expense_tracker.entity.ExpenseEntity;
import com.example.expense_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ExpenseController {
    private ExpenseService expenseService;


    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;

    }
//    @PostMapping("/expenses")
//    public ExpenseEntity addExpense(@RequestBody ExpenseEntity expense){
//    return expenseService.addExpense(expense);
//    }

    @GetMapping("/expenses")
    public List<ExpenseEntity> getAllExpenses() {
        return expenseService.getAllExpenses();

    }

    @GetMapping("/expenses/{id}")
    public ExpenseEntity getExpenseById(@PathVariable int id) {
        return expenseService.getExpenseById(id);
    }

    @PutMapping("/expenses/{id}")
    public ExpenseEntity updateExpense(@PathVariable int id, @Valid @RequestBody ExpenseEntity expense) {
        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
    }

    @GetMapping("expenses/category/{category}")
    public List<ExpenseEntity> getExpenseByCategory(@PathVariable String category) {
        return expenseService.getExpenseByCategory(category);
    }

    @GetMapping("/expenses/date/{date}")
    public List<ExpenseEntity> getExpenseByDate(@PathVariable LocalDate date) {
        return expenseService.getExpenseByDate(date);
    }

    @PostMapping("/expenses")
    public ExpenseEntity addExpenses(@Valid @RequestBody ExpenseEntity expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping("/expenses/total")
    public BigDecimal getTotalExpenses() {
        return expenseService.getTotalExpenses();
    }

    @GetMapping("/expenses/total/category/{category}")
    public BigDecimal getTotalByCategory(@PathVariable String category) {
        return
                expenseService.getTotalByCategory(category);
    }

    @GetMapping("/expenses/sort/amount")
    public List<ExpenseEntity> getExpenseSortedByAmount() {
        return
        expenseService.getExpenseSortedByAmount();

    }
}

