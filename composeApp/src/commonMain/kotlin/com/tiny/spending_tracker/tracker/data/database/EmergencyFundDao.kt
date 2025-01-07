package com.tiny.spending_tracker.tracker.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface EmergencyFundDao {

    @Upsert
    suspend fun upsertEmergencyFund(person: EmergencyFundEntity)

    @Delete
    suspend fun deleteEmergencyFund(person: EmergencyFundEntity)

    @Query("SELECT * FROM EmergencyFundEntity")
    fun getAllEmergencyFund(): Flow<List<EmergencyFundEntity>>

}