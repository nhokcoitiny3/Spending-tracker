package com.tiny.spending_tracker.tracker.presentation.tracker_home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiny.spending_tracker.Res
import com.tiny.spending_tracker.ic_expense
import com.tiny.spending_tracker.tracker.presentation.ButtonBlue
import com.tiny.spending_tracker.tracker.presentation.ColorLavender
import com.tiny.spending_tracker.tracker.presentation.ColorMagnolia
import com.tiny.spending_tracker.tracker.presentation.Coral
import com.tiny.spending_tracker.tracker.presentation.DeepCarminePink
import com.tiny.spending_tracker.tracker.presentation.LavenderIndigo
import com.tiny.spending_tracker.tracker.presentation.NeonGreen
import com.tiny.spending_tracker.tracker.presentation.White30
import org.jetbrains.compose.resources.painterResource

@Composable
fun TrackerHomeCardSummary(modifier: Modifier = Modifier) {
    val color1 = ButtonBlue
    val color2 = LavenderIndigo
    val color3 = Coral

    val gradientBrush = Brush.linearGradient(
        colors = listOf(color1, color2, color3),
        start = Offset.Zero,
        end = Offset.Infinite,
        tileMode = TileMode.Clamp
    )
    Card(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp)
            .background(brush = gradientBrush, shape = RoundedCornerShape(32.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(brush = gradientBrush, shape = RoundedCornerShape(32.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Total Balance", style = TextStyle(
                    color = ColorLavender, fontSize = 16.sp
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "1000", style = TextStyle(
                    color = ColorMagnolia, fontSize = 42.sp
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)) {
                Box(
                    modifier = Modifier.align(Alignment.CenterVertically)
                        .background(color = White30, shape = CircleShape).padding(6.dp)
                ) {
                    Icon(
                        modifier = Modifier.rotate(180f).align(Alignment.Center),
                        painter = painterResource(Res.drawable.ic_expense),
                        tint = NeonGreen,
                        contentDescription = "Income"
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "Income", style = TextStyle(
                            color = ColorLavender, fontSize = 13.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "1000", style = TextStyle(
                            color = ColorMagnolia, fontSize = 16.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier.align(Alignment.CenterVertically)
                        .background(color = White30, shape = CircleShape).padding(6.dp)
                ) {
                    Icon(
                        modifier = Modifier.align(Alignment.Center),
                        painter = painterResource(Res.drawable.ic_expense),
                        tint = DeepCarminePink,
                        contentDescription = "Expense"
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "Expense", style = TextStyle(
                            color = ColorLavender, fontSize = 13.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "1000", style = TextStyle(
                            color = ColorMagnolia, fontSize = 16.sp
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

        }
    }
}
