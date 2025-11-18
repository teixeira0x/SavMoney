package com.teixeira0x.savmoney.ui.screen.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.teixeira0x.savmoney.data.model.Expense


@Composable
fun ExpensesList(
    modifier: Modifier = Modifier,
    expenses: List<Expense>
) {
    LazyColumn(modifier = modifier) {
        items(items = expenses) { expense ->
            ExpenseItem(expense = expense)
        }
    }
}

@Composable
fun ExpenseItem(expense: Expense) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = expense.description)
        Text(text = expense.amount.toString())
        Text(text = expense.date.toString())
    }
}