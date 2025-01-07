package com.tiny.spending_tracker.tracker.data.mappers

import com.tiny.spending_tracker.tracker.data.database.ExpenseEntity
import com.tiny.spending_tracker.tracker.data.repository.Expense

fun ExpenseEntity.toExpense(): Expense {
    return Expense(
        id = id,
        description = description,
        date = date,
        amount = amount,
        categoryId = categoryId,
    )
}