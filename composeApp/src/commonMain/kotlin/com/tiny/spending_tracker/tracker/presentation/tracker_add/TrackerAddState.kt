package com.tiny.spending_tracker.tracker.presentation.tracker_add

import com.tiny.spending_tracker.tracker.data.repository.Category

data class TrackerAddState(
    val isLoading: Boolean = false,
    val listCategory: List<Category> = emptyList()
)
