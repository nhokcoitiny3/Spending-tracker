package database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class SinkingFund(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val description: String,
    val date: Long,
    val amount: Long
)