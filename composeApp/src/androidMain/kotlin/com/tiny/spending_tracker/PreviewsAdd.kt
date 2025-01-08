package com.tiny.spending_tracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tiny.spending_tracker.tracker.presentation.ColorBackground
import com.tiny.spending_tracker.tracker.presentation.tracker_add.components.TrackerAddHeader
import com.tiny.spending_tracker.tracker.presentation.tracker_add.components.TrackerAddInputAmount

@Composable
@Preview
fun PreviewTrackerAddHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ColorBackground)
    ) {
        TrackerAddHeader()
    }
}

@Composable
@Preview
fun PreviewTrackerAddInputAmount() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ColorBackground)
    ) {
        TrackerAddInputAmount()
    }
}

@Composable
@Preview
fun PreviewTrackerAdd() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorBackground)
            .padding(16.dp)
    ) {
        TrackerAddHeader(onClickClose = {})

        Spacer(modifier = Modifier.height(130.dp))

        TrackerAddInputAmount(modifier = Modifier.align(Alignment.CenterHorizontally))

    }
}
