package com.tiny.spending_tracker.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.tiny.spending_tracker.database.DatabaseFactory
import com.tiny.spending_tracker.database.ExpenseDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<ExpenseDatabase>().expenseDao() }

}