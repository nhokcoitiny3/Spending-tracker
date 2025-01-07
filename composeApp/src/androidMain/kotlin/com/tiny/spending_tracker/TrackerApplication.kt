package com.tiny.spending_tracker
import android.app.Application
import com.tiny.spending_tracker.di.initKoin
import org.koin.android.ext.koin.androidContext

class TrackerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@TrackerApplication)
        }
    }
}