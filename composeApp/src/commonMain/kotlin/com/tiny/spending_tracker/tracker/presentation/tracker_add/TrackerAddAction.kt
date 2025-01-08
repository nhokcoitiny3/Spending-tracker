package com.tiny.spending_tracker.tracker.presentation.tracker_add

sealed interface TrackerAddAction {
    data object OnClickSelectCategory : TrackerAddAction
    data object OnClickClose : TrackerAddAction
}