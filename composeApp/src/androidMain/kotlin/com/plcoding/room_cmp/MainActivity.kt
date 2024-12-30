package com.plcoding.room_cmp

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.plcoding.room_cmp.database.getExpenseDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = getExpenseDatabase(applicationContext).peopleDao()
        setContent {
            App(dao)
        }
    }
}