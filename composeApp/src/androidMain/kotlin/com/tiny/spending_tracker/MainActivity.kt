package com.tiny.spending_tracker

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tiny.spending_tracker.database.getExpenseDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = getExpenseDatabase(applicationContext).peopleDao()
        setContent {
            App(dao)
        }
    }
}