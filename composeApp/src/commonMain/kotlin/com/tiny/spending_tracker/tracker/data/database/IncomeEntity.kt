package com.tiny.spending_tracker.tracker.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class IncomeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val description: String,
    val date: Long,
    val amount: Long
)
