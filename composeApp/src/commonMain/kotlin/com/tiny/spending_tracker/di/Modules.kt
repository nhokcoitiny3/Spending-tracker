package com.tiny.spending_tracker.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.tiny.spending_tracker.tracker.data.database.DatabaseFactory
import com.tiny.spending_tracker.tracker.data.database.TrackerDatabase
import com.tiny.spending_tracker.tracker.data.repository.DefaultTrackerRepository
import com.tiny.spending_tracker.tracker.domain.TrackerRepository
import com.tiny.spending_tracker.tracker.presentation.tracker_home.TrackerHomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
expect val platformModule: Module

val sharedModule = module {
    singleOf(::DefaultTrackerRepository).bind<TrackerRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<TrackerDatabase>().expenseDao() }

    viewModelOf(::TrackerHomeViewModel)

}