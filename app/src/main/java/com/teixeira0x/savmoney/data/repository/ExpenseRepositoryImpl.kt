package com.teixeira0x.savmoney.data.repository

import com.teixeira0x.savmoney.App
import com.teixeira0x.savmoney.data.db.entity.ExpenseEntity
import com.teixeira0x.savmoney.data.model.Expense

class ExpenseRepositoryImpl : ExpenseRepository {
    private val expenseDao by lazy { App.instance.db.expenseDao() }

    override suspend fun addExpense(expense: Expense) {
        expenseDao.insert(expense.toEntity())
    }

    override suspend fun updateExpense(expense: Expense) {
        expenseDao.update(expense.toEntity())
    }

    override suspend fun removeExpense(expense: Expense) {
        expenseDao.delete(expense.toEntity())
    }

    override suspend fun getExpense(id: Long): Expense? {
        return expenseDao.findById(id.toInt())?.toModel()
    }

    override suspend fun getExpenses(): List<Expense> {
        return expenseDao.getAllExpenses().map { it.toModel() }
    }

    private fun Expense.toEntity(): ExpenseEntity {
        return ExpenseEntity(
            title = title,
            amount = amount,
            date = date,
            description = description,
            category = category,
            type = type
        )
    }

    private fun ExpenseEntity.toModel(): Expense {
        return Expense(
            id = id,
            title = title,
            amount = amount,
            date = date,
            description = description,
            category = category,
            type = type
        )
    }
}
