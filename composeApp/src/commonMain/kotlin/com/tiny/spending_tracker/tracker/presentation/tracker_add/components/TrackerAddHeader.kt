package com.tiny.spending_tracker.tracker.presentation.tracker_add.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiny.spending_tracker.Res
import com.tiny.spending_tracker.ic_close
import com.tiny.spending_tracker.tracker.presentation.SlateGray
import org.jetbrains.compose.resources.painterResource

@Composable
fun TrackerAddHeader(onClickClose: () -> Unit = {}) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            style = TextStyle(
                color = SlateGray, fontSize = 18.sp, fontWeight = FontWeight(600)
            ),
            text = "Add New",
        )

        Image(
            modifier = Modifier.size(32.dp).padding(8.dp).align(Alignment.CenterEnd).clickable {
                onClickClose()
            }, painter = painterResource(Res.drawable.ic_close), contentDescription = "Logo"
        )
    }
}