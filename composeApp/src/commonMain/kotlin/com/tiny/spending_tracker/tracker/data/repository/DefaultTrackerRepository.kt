package com.tiny.spending_tracker.tracker.data.repository

import com.tiny.spending_tracker.tracker.data.database.ExpenseDao
import com.tiny.spending_tracker.tracker.data.mappers.toExpense
import com.tiny.spending_tracker.tracker.domain.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultTrackerRepository(private val expenseDao: ExpenseDao) : TrackerRepository {
    override fun getAllExpense(): Flow<List<Expense>> {
        return expenseDao.getAllExpense().map { expenseEntities ->
            expenseEntities.map { it.toExpense() }
        }
    }
}