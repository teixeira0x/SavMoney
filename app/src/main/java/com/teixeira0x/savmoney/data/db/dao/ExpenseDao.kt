package com.teixeira0x.savmoney.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.teixeira0x.savmoney.data.db.entity.ExpenseEntity

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insert(expense: ExpenseEntity)

    @Insert
    suspend fun insertAll(vararg entities: ExpenseEntity)

    @Update
    suspend fun update(entity: ExpenseEntity)

    @Query("SELECT * FROM expenses WHERE id LIKE :id LIMIT 1")
    suspend fun findById(id: Int): ExpenseEntity?

    @Delete
    suspend fun delete(entity: ExpenseEntity)

    @Query("SELECT * FROM expenses")
    suspend fun getAllExpenses(): List<ExpenseEntity>
}