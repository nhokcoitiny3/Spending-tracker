package database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Expense::class, EmergencyFund::class, Income::class, SinkingFund::class, Category::class],
    version = 1
)
abstract class ExpenseDatabase : RoomDatabase() {

    abstract fun peopleDao(): ExpenseDao

}