package com.tiny.spending_tracker.tracker.domain

import com.tiny.spending_tracker.tracker.data.repository.Expense
import kotlinx.coroutines.flow.Flow

interface TrackerRepository {
    fun getAllExpense(): Flow<List<Expense>>
}