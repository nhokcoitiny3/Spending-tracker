package com.tiny.spending_tracker.tracker.data.database

import androidx.room.RoomDatabase
expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<TrackerDatabase>
}
