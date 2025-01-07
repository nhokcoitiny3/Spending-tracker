package com.tiny.spending_tracker.tracker.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tiny.spending_tracker.tracker.data.database.TrackerDatabase

actual class DatabaseFactory(
    private val context: Context
) {
    actual fun create(): RoomDatabase.Builder<TrackerDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(TrackerDatabase.DB_NAME)

        return Room.databaseBuilder(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}