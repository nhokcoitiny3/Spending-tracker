package com.tiny.spending_tracker.tracker.data.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.tiny.spending_tracker.tracker.data.database.TrackerDatabase

fun getExpenseDatabase(context: Context): TrackerDatabase {
    val dbFile = context.getDatabasePath("expense.db")
    return Room.databaseBuilder<TrackerDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}