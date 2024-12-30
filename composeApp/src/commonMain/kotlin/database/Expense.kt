package database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val description: String,
    val date: Long,
    val amount: Long,
    val categoryId: Long,
)