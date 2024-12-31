package com.tiny.spending_tracker.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tiny.spending_tracker.database.Expense
import com.tiny.spending_tracker.database.ExpenseDao
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(expenseDao: ExpenseDao) {
    MaterialTheme {
        val people by expenseDao.getAllExpense().collectAsState(initial = emptyList())
        val scope = rememberCoroutineScope()

        LaunchedEffect(true) {
            val expenseList = listOf(
                Expense(description = "An uong sinh hoat",date = 123456789,amount = 100,categoryId = 1),
                Expense(description = "An ngoai",date = 123456789,amount = 100,categoryId = 1),
                Expense(description = "Chi tiet bat buoc",date = 123456789,amount = 100,categoryId = 1),
            )
            expenseList.forEach {
                expenseDao.upsert(it)
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
        ) {
            items(people) { person ->
                Text(
                    text = person.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            scope.launch {
                                expenseDao.delete(person)
                            }
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}