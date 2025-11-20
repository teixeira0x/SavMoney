package com.teixeira0x.savmoney.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val amount: Double,
    val date: String,
    val category: String,
    val description: String,
    val type: String
)