package com.tiny.spending_tracker.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Expense::class, EmergencyFund::class, Income::class, SinkingFund::class, Category::class],
    version = 1
)
abstract class ExpenseDatabase : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao
    companion object {
        const val DB_NAME = "expenses.db"
    }
}