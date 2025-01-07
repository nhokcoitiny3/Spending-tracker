package com.tiny.spending_tracker.tracker.presentation.tracker_home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tiny.spending_tracker.Res
import com.tiny.spending_tracker.ic_menu
import com.tiny.spending_tracker.ic_statistic
import com.tiny.spending_tracker.tracker.presentation.ColorWhite
import org.jetbrains.compose.resources.painterResource

@Composable
fun TrackerHomeFooter(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth()
            .background(color = ColorWhite, shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .padding(16.dp)
    ) {
        Image(
            modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
            painter = painterResource(Res.drawable.ic_menu),
            contentDescription = "menu"
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
            painter = painterResource(Res.drawable.ic_statistic),
            contentDescription = "statistic"
        )
    }
}