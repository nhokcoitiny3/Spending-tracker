package com.tiny.spending_tracker.tracker.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.tiny.spending_tracker.tracker.data.database.TrackerDatabase
import java.io.File

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<TrackerDatabase> {
        val os = System.getProperty("os.name").lowercase()
        val userHome = System.getProperty("user.home")
        val appDataDir = when {
            os.contains("win") -> File(System.getenv("APPDATA"), "SpendingTracker")
            os.contains("mac") -> File(userHome, "Library/Application Support/SpendingTracker")
            else -> File(userHome, ".local/share/SpendingTracker")
        }

        if(!appDataDir.exists()) {
            appDataDir.mkdirs()
        }

        val dbFile = File(appDataDir, TrackerDatabase.DB_NAME)
        return Room.databaseBuilder(dbFile.absolutePath)
    }
}