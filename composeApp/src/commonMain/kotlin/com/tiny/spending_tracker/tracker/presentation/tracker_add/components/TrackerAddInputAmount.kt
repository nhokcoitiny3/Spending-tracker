package com.tiny.spending_tracker.tracker.presentation.tracker_add.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiny.spending_tracker.tracker.presentation.ButtonBlue
import com.tiny.spending_tracker.tracker.presentation.Coral
import com.tiny.spending_tracker.tracker.presentation.LavenderIndigo

@Composable
fun TrackerAddInputAmount(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("1000") }

    val color1 = ButtonBlue
    val color2 = LavenderIndigo
    val color3 = Coral

    val gradientBrush = Brush.linearGradient(
        colors = listOf(color1, color2, color3),
        start = Offset.Zero,
        end = Offset(0f, Float.POSITIVE_INFINITY),
        tileMode = TileMode.Clamp
    )

    TextField(
        value = text, onValueChange = { text = it }, modifier = modifier.padding(16.dp).background(
            color = Color.White, shape = RoundedCornerShape(40.dp)
        ).textBrush(gradientBrush), colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ), keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
        ), textStyle = TextStyle(textAlign = TextAlign.Center, fontSize = 32.sp), maxLines = 1
    )

}

fun Modifier.textBrush(brush: Brush) = this.graphicsLayer(alpha = 0.99f).drawWithCache {
    onDrawWithContent {
        drawContent()
        drawRect(brush, blendMode = BlendMode.SrcAtop)
    }
}