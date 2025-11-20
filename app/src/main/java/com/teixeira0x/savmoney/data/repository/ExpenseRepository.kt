package com.teixeira0x.savmoney.data.repository

import com.teixeira0x.savmoney.data.model.Expense

interface ExpenseRepository {

    companion object {
        val instance: ExpenseRepository by lazy { ExpenseRepositoryImpl() }
    }
    suspend fun addExpense(expense: Expense)

    suspend fun updateExpense(expense: Expense)

    suspend fun removeExpense(expense: Expense)

    suspend fun getExpense(id: Long): Expense?

    suspend fun getExpenses(): List<Expense>
}