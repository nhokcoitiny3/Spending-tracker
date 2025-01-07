package com.tiny.spending_tracker.tracker.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Upsert
    suspend fun upsertExpense(person: ExpenseEntity)

    @Delete
    suspend fun deleteExpense(person: ExpenseEntity)

    @Query("SELECT * FROM ExpenseEntity")
    fun getAllExpense(): Flow<List<ExpenseEntity>>

}