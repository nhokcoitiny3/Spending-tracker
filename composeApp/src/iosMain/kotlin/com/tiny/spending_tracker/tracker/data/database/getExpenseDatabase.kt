package com.tiny.spending_tracker.tracker.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.tiny.spending_tracker.tracker.data.database.TrackerDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<TrackerDatabase> {
        val dbFile = documentDirectory() + "/${TrackerDatabase.DB_NAME}"
        return Room.databaseBuilder<TrackerDatabase>(
            name = dbFile
        )
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun documentDirectory(): String {
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null
        )
        return requireNotNull(documentDirectory?.path)
    }
}