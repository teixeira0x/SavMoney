package com.teixeira0x.savmoney.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teixeira0x.savmoney.data.model.Expense
import com.teixeira0x.savmoney.data.repository.ExpenseRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val expenseRepository = ExpenseRepository.instance

    private var _viewState by mutableStateOf(HomeViewState())

    val viewState: HomeViewState
        get() = _viewState

    fun loadExpenses() {
        viewModelScope.launch {
            _viewState = viewState.copy(expenses = expenseRepository.getExpenses())
        }
    }

    data class HomeViewState(
        val expenses: List<Expense> = emptyList()
    )
}