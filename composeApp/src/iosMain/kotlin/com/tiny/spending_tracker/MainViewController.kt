package com.tiny.spending_tracker

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.tiny.spending_tracker.app.App
import com.tiny.spending_tracker.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }