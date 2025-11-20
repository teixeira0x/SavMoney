package com.teixeira0x.savmoney.ui.screen.addexpense

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teixeira0x.savmoney.data.model.Expense
import com.teixeira0x.savmoney.data.repository.ExpenseRepository
import kotlinx.coroutines.launch

class AddExpenseViewModel: ViewModel() {
    private val expenseRepository = ExpenseRepository.instance

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.addExpense(expense)
        }
    }
}