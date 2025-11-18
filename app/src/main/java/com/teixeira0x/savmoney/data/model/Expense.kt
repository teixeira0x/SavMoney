package com.teixeira0x.savmoney.data.model

const val TYPE_VARIABLE = "variable"
const val TYPE_FIXED = "fixed"

data class Expense(
    val date: String,
    val type: String,
    val description: String,
    val amount: Double
)