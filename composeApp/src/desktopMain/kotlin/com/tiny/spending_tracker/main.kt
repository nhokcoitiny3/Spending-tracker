package com.tiny.spending_tracker

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.tiny.spending_tracker.app.App
import com.tiny.spending_tracker.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Spending Tracker",
        ) {
            App()
        }
    }
}