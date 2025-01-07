package com.tiny.spending_tracker.tracker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ExpenseEntity::class, EmergencyFundEntity::class, IncomeEntity::class, SinkingFundEntity::class, CategoryEntity::class],
    version = 1
)
abstract class TrackerDatabase : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao
    abstract fun categoryDao(): CategoryDao
    abstract fun incomeDao(): IncomeDao
    abstract fun emergencyFundDao(): EmergencyFundDao
    abstract fun sinkingFundDao(): SinkingFundDao

    companion object {
        const val DB_NAME = "spending_tracker.db"
    }
}