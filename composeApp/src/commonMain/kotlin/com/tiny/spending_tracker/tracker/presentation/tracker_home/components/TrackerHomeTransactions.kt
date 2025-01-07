package com.tiny.spending_tracker.tracker.presentation.tracker_home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiny.spending_tracker.Res
import com.tiny.spending_tracker.ic_empty
import com.tiny.spending_tracker.tracker.data.repository.Expense
import com.tiny.spending_tracker.tracker.presentation.CadetGrey
import com.tiny.spending_tracker.tracker.presentation.ColorWhite
import com.tiny.spending_tracker.tracker.presentation.PastelBlue
import com.tiny.spending_tracker.tracker.presentation.SlateGray
import org.jetbrains.compose.resources.painterResource

@Composable
fun TrackerHomeTransactions(modifier: Modifier = Modifier, list: List<Expense>) {
    Column(modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = "Transactions",
                style = TextStyle(
                    color = SlateGray, fontSize = 18.sp
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = "View All",
                style = TextStyle(
                    color = PastelBlue, fontSize = 14.sp
                )
            )
        }


        if (list.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_empty), contentDescription = "empty"
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "No transactions yet", style = TextStyle(
                        color = CadetGrey, fontSize = 16.sp
                    )
                )

            }
        } else {
            Spacer(modifier = Modifier.height(24.dp))
            LazyColumn(
                modifier = Modifier
            ) {
                items(items = list) { expense ->
                    TrackerHomeItemTransaction(expense = expense)

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun TrackerHomeItemTransaction(expense: Expense) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(color = ColorWhite, shape = RoundedCornerShape(16.dp)).padding(16.dp),
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = expense.description,
            style = TextStyle(
                color = SlateGray, fontSize = 16.sp
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Column {
            Text(
                text = expense.amount.toString(), style = TextStyle(
                    color = CadetGrey, fontSize = 16.sp
                )
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = expense.date.toString(), style = TextStyle(
                    color = PastelBlue, fontSize = 16.sp
                )
            )
        }
    }
}