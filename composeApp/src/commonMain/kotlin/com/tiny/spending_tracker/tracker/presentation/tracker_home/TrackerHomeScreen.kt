package com.tiny.spending_tracker.tracker.presentation.tracker_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tiny.spending_tracker.Res
import com.tiny.spending_tracker.ic_add
import com.tiny.spending_tracker.tracker.data.repository.Expense
import com.tiny.spending_tracker.tracker.presentation.ButtonBlue
import com.tiny.spending_tracker.tracker.presentation.ColorBackground
import com.tiny.spending_tracker.tracker.presentation.Coral
import com.tiny.spending_tracker.tracker.presentation.LavenderIndigo
import com.tiny.spending_tracker.tracker.presentation.tracker_home.components.TrackerHomeCardSummary
import com.tiny.spending_tracker.tracker.presentation.tracker_home.components.TrackerHomeFooter
import com.tiny.spending_tracker.tracker.presentation.tracker_home.components.TrackerHomeHeader
import com.tiny.spending_tracker.tracker.presentation.tracker_home.components.TrackerHomeTransactions
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TrackerHomeScreenRoot(
    viewModel: TrackerHomeViewModel = koinViewModel(), onClickAdd: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    TrackerHomeScreen(listExpense = state.listExpense, onAction = { action ->
        when (action) {
            is TrackerHomeAction.OnClickAddNew -> onClickAdd()
            else -> Unit
        }
        viewModel.onAction(action)
    })
}

@Composable
fun TrackerHomeScreen(
    listExpense: List<Expense>,
    onAction: (TrackerHomeAction) -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current


    ConstraintLayout(modifier = Modifier.fillMaxSize().background(color = ColorBackground)) {
        val (header, card, transactions, footer, btnAdd) = createRefs()

        TrackerHomeHeader(modifier = Modifier.constrainAs(header) {
            top.linkTo(parent.top, margin = 12.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })


        TrackerHomeCardSummary(modifier = Modifier.constrainAs(card) {
            top.linkTo(header.bottom, margin = 12.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })


        TrackerHomeFooter(modifier = Modifier.constrainAs(footer) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        val color1 = Coral
        val color2 = LavenderIndigo
        val color3 = ButtonBlue

        val gradientBrush = Brush.linearGradient(
            colors = listOf(color1, color2, color3),
            start = Offset.Zero,
            end = Offset.Infinite,
            tileMode = TileMode.Clamp
        )

        Card(
            modifier = Modifier.size(64.dp)
                .background(brush = gradientBrush, shape = RoundedCornerShape(32.dp))
                .constrainAs(btnAdd) {
                    top.linkTo(footer.top)
                    bottom.linkTo(footer.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }, elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ), shape = RoundedCornerShape(32.dp)
        ) {
            Box(
                modifier = Modifier.size(64.dp)
                    .background(brush = gradientBrush, shape = RoundedCornerShape(32.dp))
            ) {
                Image(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(Res.drawable.ic_add),
                    contentDescription = "add"
                )
            }
        }

        TrackerHomeTransactions(modifier = Modifier.constrainAs(transactions) {
            top.linkTo(card.bottom, margin = 32.dp)
            bottom.linkTo(footer.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            height = Dimension.fillToConstraints
        }, list = listExpense)

    }
}