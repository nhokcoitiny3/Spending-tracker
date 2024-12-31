package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.tiny.spending_tracker.database.ExpenseDatabase
import platform.Foundation.NSHomeDirectory

fun getExpenseDatabase(): ExpenseDatabase {
    val dbFile = NSHomeDirectory() + "/expense.db"
    return Room.databaseBuilder<ExpenseDatabase>(
        name = dbFile,
        factory = { ExpenseDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}