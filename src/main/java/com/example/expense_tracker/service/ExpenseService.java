package com.example.expense_tracker.service;

import com.example.expense_tracker.entity.ExpenseEntity;
import com.example.expense_tracker.repository.ExpenseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository=expenseRepository;
    }

    public ExpenseEntity addExpense(ExpenseEntity expense){
       return expenseRepository.save(expense);
    }

    public List<ExpenseEntity> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public ExpenseEntity getExpenseById(Integer id){

        return expenseRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Expense not found with id: " +id));
    }
    public ExpenseEntity updateExpense(Integer id,ExpenseEntity expense){
       ExpenseEntity existingExpense = expenseRepository.findById(id)
               .orElseThrow(()->new ResponseStatusException(
                       HttpStatus.NOT_FOUND,
                       "Expense not found: " +id
                       ));

               existingExpense.setTitle(expense.getTitle());
               existingExpense.setAmount(expense.getAmount());
               existingExpense.setCategory(expense.getCategory());
               existingExpense.setDate(expense.getDate());

               return
                       expenseRepository.save(existingExpense);

    }

    public void deleteExpense(Integer id){
        expenseRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Expenses not found with id: " +id
                ));
        expenseRepository.deleteById(id);
    }
    public List<ExpenseEntity> getExpenseByCategory(String category){
        return expenseRepository.findByCategory(category);
    }
    public List<ExpenseEntity> getExpenseByDate(LocalDate date){
        LocalDateTime start =
                date.atStartOfDay();
        LocalDateTime end = date.atTime(23,59,59);

        return expenseRepository.findByDateBetween(start,end);
    }
    public BigDecimal getTotalExpenses(){
        return expenseRepository.getTotalExpenses();
    }
    public BigDecimal getTotalByCategory(String category){
        return expenseRepository.getTotalByCategory(category);
    }
    public List<ExpenseEntity> getExpenseSortedByAmount(){
        return expenseRepository.findAllByOrderByAmountDesc();
    }
}
