package com.tiny.spending_tracker.tracker.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface IncomeDao {

    @Upsert
    suspend fun upsertIncome(person: IncomeEntity)

    @Delete
    suspend fun deleteIncome(person: IncomeEntity)

    @Query("SELECT * FROM IncomeEntity")
    fun getAllIncome(): Flow<List<IncomeEntity>>

}