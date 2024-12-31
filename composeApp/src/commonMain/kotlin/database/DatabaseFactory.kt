package database

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<ExpenseDatabase>
}
//https://github.com/philipplackner/CMP-Bookpedia/blob/master/composeApp/src/commonMain/kotlin/com/plcoding/bookpedia/book/data/database/DatabaseFactory.kt