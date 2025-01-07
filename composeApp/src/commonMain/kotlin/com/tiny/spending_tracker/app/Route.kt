package com.tiny.spending_tracker.app

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object TrackerGraph: Route

    @Serializable
    data object TrackerHome: Route

    @Serializable
    data object ExpenseList: Route
}