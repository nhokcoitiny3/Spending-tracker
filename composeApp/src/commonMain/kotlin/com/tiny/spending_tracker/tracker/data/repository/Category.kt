package com.tiny.spending_tracker.tracker.data.repository

data class Category(
    val id: Int = 0,
    val name: String,
    val budgetLimit: Long,
)