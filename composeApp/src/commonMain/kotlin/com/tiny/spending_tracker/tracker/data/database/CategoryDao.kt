package com.tiny.spending_tracker.tracker.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Upsert
    suspend fun upsertCategory(person: CategoryEntity)

    @Delete
    suspend fun deleteCategory(person: CategoryEntity)

    @Query("SELECT * FROM CategoryEntity")
    fun getAllCategory(): Flow<List<CategoryEntity>>

}