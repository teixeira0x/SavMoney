package com.teixeira0x.savmoney.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.teixeira0x.savmoney.data.db.dao.ExpenseDao
import com.teixeira0x.savmoney.data.db.entity.ExpenseEntity

@Database(entities = [ExpenseEntity::class], version = 1)
abstract class SavDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
}