package com.mongodb.springboot.service;

import com.mongodb.springboot.model.Expense;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;

import java.util.List;

public interface ExpenseService {
    public Expense addExpense(Expense expense);

    public Expense updateExpense(Expense expense);

    public void deleteExpense(String id);

    public List<Expense> getAllExpenses();

    public Expense getExpenseByName(String name);
}
