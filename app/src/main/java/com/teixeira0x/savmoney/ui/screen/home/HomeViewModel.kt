package com.teixeira0x.savmoney.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.teixeira0x.savmoney.data.model.Expense

class HomeViewModel : ViewModel() {

    private var _viewState by mutableStateOf(HomeViewState())

    val viewState: HomeViewState
        get() = _viewState

    fun loadExpenses() {
        _viewState = viewState.copy(expenses = listOf(Expense("22", "", "teste", 40.9)))
    }

    data class HomeViewState(
        val expenses: List<Expense> = emptyList()
    )
}