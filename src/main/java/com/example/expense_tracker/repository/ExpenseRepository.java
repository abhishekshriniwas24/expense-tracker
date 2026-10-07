package com.example.expense_tracker.repository;

import com.example.expense_tracker.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Integer> {

    List<ExpenseEntity> findByCategory(String category);

    List<ExpenseEntity> findByDateBetween(
            LocalDateTime start,
            LocalDateTime end
    );

    @Query("SELECT SUM(e.amount) FROM ExpenseEntity e")
    BigDecimal getTotalExpenses();

    @Query("SELECT SUM(e.amount) FROM ExpenseEntity e WHERE e.category = :category")
    BigDecimal
    getTotalByCategory(@Param("category"
    )String category);

    List<ExpenseEntity> findAllByOrderByAmountDesc();


    }



