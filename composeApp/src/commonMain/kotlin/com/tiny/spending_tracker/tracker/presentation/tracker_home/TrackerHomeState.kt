package com.tiny.spending_tracker.tracker.presentation.tracker_home

import com.tiny.spending_tracker.tracker.data.repository.Expense

data class TrackerHomeState (
    val isLoading: Boolean = false,
    val listExpense: List<Expense> = emptyList()
)