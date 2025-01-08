package com.tiny.spending_tracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tiny.spending_tracker.tracker.data.repository.Expense
import com.tiny.spending_tracker.tracker.presentation.ColorBackground
import com.tiny.spending_tracker.tracker.presentation.tracker_home.TrackerHomeScreen
import com.tiny.spending_tracker.tracker.presentation.tracker_home.components.TrackerHomeCardSummary
import com.tiny.spending_tracker.tracker.presentation.tracker_home.components.TrackerHomeFooter
import com.tiny.spending_tracker.tracker.presentation.tracker_home.components.TrackerHomeHeader
import com.tiny.spending_tracker.tracker.presentation.tracker_home.components.TrackerHomeItemTransaction
import com.tiny.spending_tracker.tracker.presentation.tracker_home.components.TrackerHomeTransactions

@Composable
@Preview
fun PreviewTrackerHomeHeader() {
    Box(modifier = Modifier.background(color = ColorBackground)) {
        TrackerHomeHeader()
    }
}

@Composable
@Preview
fun PreviewTrackerHomeCardSummary() {
    Box(modifier = Modifier.background(color = ColorBackground)) {
        TrackerHomeCardSummary()
    }
}

@Composable
@Preview
fun PreviewTrackerHomeItemTransactions() {
    Box(modifier = Modifier.background(color = ColorBackground)) {
        TrackerHomeItemTransaction(
            expense = Expense(1, "Description 1", 100L, 100L, 1)
        )
    }
}

@Composable
@Preview
fun PreviewTrackerHomeFooter() {
    Box(modifier = Modifier.background(color = ColorBackground)) {
        TrackerHomeFooter()
    }
}

@Composable
@Preview
fun PreviewTrackerHomeTransactions() {
    Box(modifier = Modifier.background(color = ColorBackground)) {
        TrackerHomeTransactions(
            list = listOf(
                Expense(1, "Description 1", 100L, 100L, 1),
                Expense(2, "Description 2", 200L, 200L, 1),
                Expense(3, "Description 3", 300L, 300L, 1),
            )
        )
    }
}

@Composable
@Preview
fun PreviewTrackerHome() {
    TrackerHomeScreen(
        listExpense = listOf(
            Expense(1, "Description 1", 100L, 100L, 1),
            Expense(2, "Description 2", 200L, 200L, 1),
            Expense(3, "Description 3", 300L, 300L, 1),
        ),
        onAction = {}
    )
}

@Composable
@Preview
fun PreviewTrackerHomeEmpty() {
    TrackerHomeScreen(
        listExpense = listOf(),
        onAction = {}
    )
}