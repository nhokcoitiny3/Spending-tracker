package com.tiny.spending_tracker.tracker.presentation.tracker_home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiny.spending_tracker.Res
import com.tiny.spending_tracker.ic_profile
import com.tiny.spending_tracker.ic_settings
import com.tiny.spending_tracker.tracker.presentation.SlateGray
import com.tiny.spending_tracker.tracker.presentation.PastelBlue
import com.tiny.spending_tracker.tracker.presentation.ColorWhite
import org.jetbrains.compose.resources.painterResource

@Composable
fun TrackerHomeHeader(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth().padding(16.dp)) {
        Image(
            modifier = Modifier.size(32.dp).align(Alignment.CenterVertically),
            painter = painterResource(Res.drawable.ic_profile),
            contentDescription = "Logo"
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f).align(Alignment.CenterVertically)) {
            Text(text = "Welcome!", color = PastelBlue, fontSize = 13.sp)

            Spacer(modifier = Modifier.size(6.dp))

            Text(
                text = "John Doe", color = SlateGray, fontSize = 18.sp
            )
        }

        Box(
            modifier = Modifier.size(36.dp)
                .background(color = ColorWhite, RoundedCornerShape(12.dp))
                .align(Alignment.CenterVertically)
        ) {
            Image(
                modifier = Modifier.size(24.dp).align(Alignment.Center),
                painter = painterResource(Res.drawable.ic_settings),
                contentDescription = "Logo"
            )
        }
    }
}

