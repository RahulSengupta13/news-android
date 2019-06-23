package me.rahulsengupta.news.core.di

import me.rahulsengupta.news.core.retrofit.RetrofitFactory.createCountryRetrofitClient
import me.rahulsengupta.news.core.retrofit.RetrofitFactory.createNewsRetrofitClient
import me.rahulsengupta.news.home.HomeApi
import me.rahulsengupta.news.home.HomeApiImpl
import me.rahulsengupta.news.home.HomeAvm
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DependencyInjectionModules {

    val homeActivityModule = module {
        single<HomeApi> { HomeApiImpl(get(), get()) }
        viewModel { HomeAvm() }
    }

    val appModule = module {
        single { createCountryRetrofitClient() }
        single { createNewsRetrofitClient() }
    }
}