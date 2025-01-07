package com.tiny.spending_tracker.tracker.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface SinkingFundDao {

    @Upsert
    suspend fun upsertSinkingFund(person: SinkingFundEntity)

    @Delete
    suspend fun deleteSinkingFund(person: SinkingFundEntity)

    @Query("SELECT * FROM SinkingFundEntity")
    fun getAllSinkingFund(): Flow<List<SinkingFundEntity>>

}