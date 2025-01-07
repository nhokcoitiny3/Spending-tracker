package com.tiny.spending_tracker.tracker.data.repository

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Expense(
    val id: Int = 0,
    val description: String,
    val date: Long,
    val amount: Long,
    val categoryId: Int,
)