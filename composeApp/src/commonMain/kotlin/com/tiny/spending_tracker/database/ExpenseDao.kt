package com.tiny.spending_tracker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Upsert
    suspend fun upsert(person: Expense)

    @Delete
    suspend fun delete(person: Expense)

    @Query("SELECT * FROM expense")
    fun getAllExpense(): Flow<List<Expense>>

}