package me.rahulsengupta.news.core.application

import android.app.Application
import me.rahulsengupta.news.core.di.appModule
import me.rahulsengupta.news.core.di.homeActivityModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger()
            androidContext(this@NewsApplication)
            modules(listOf(appModule, homeActivityModule))
        }
    }
}