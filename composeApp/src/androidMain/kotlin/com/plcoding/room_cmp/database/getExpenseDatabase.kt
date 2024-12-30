package com.plcoding.room_cmp.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.ExpenseDatabase

fun getExpenseDatabase(context: Context): ExpenseDatabase {
    val dbFile = context.getDatabasePath("expense.db")
    return Room.databaseBuilder<ExpenseDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}