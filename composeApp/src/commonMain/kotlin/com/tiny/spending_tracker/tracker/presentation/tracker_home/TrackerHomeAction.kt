package com.tiny.spending_tracker.tracker.presentation.tracker_home

sealed interface TrackerHomeAction {
    data object OnClickViewAll : TrackerHomeAction
}