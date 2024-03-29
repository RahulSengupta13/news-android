package me.rahulsengupta.news.core.application

import android.app.Application
import me.rahulsengupta.news.core.di.DependencyInjectionModules.appModule
import me.rahulsengupta.news.core.di.DependencyInjectionModules.countryModule
import me.rahulsengupta.news.core.di.DependencyInjectionModules.homeFragmentModule
import me.rahulsengupta.news.core.di.DependencyInjectionModules.settingsFragmentModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        /*DI setup*/
        startKoin {
            androidLogger()
            androidContext(this@NewsApplication)

            modules(
                listOf(
                    appModule,
                    countryModule,
                    homeFragmentModule,
                    settingsFragmentModule
                )
            )
        }
    }
}