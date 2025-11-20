package com.teixeira0x.savmoney.data.model

data class Expense(
    val id: Int = 0,
    val title: String,
    val date: String,
    val type: String,
    val category: String,
    val description: String,
    val amount: Double
)

object ExpenseType {
    const val TYPE_VARIABLE = "variable"
    const val TYPE_FIXED = "fixed"
    val ALL_TYPES = listOf<String>(TYPE_FIXED, TYPE_VARIABLE)
}
