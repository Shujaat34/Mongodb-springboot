package com.mongodb.springboot.service;

import com.mongodb.springboot.model.Expense;
import com.mongodb.springboot.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        Expense exp = expenseRepository.findById(expense.getId())
                .orElseThrow(()-> new RuntimeException("Can not find Expense by id "+expense.getId()));

        exp.setExpenseName(expense.getExpenseName());
        exp.setExpenseCategory(exp.getExpenseCategory());
        exp.setExpenseAmount(expense.getExpenseAmount());

        return expenseRepository.save(exp);
    }

    @Override
    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException("Can not find Expense by Name "+name));

    }
}
