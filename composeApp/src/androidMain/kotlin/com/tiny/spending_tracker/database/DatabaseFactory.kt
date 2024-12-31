package com.tiny.spending_tracker.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

actual class DatabaseFactory(
    private val context: Context
) {
    actual fun create(): RoomDatabase.Builder<ExpenseDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(ExpenseDatabase.DB_NAME)

        return Room.databaseBuilder(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}