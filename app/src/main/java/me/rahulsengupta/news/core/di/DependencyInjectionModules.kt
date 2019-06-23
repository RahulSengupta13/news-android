package me.rahulsengupta.news.core.di

import me.rahulsengupta.news.core.db.NewsDb
import me.rahulsengupta.news.core.db.RoomFactory.initializeDatabase
import me.rahulsengupta.news.core.db.entities.countrylist.CountryListDb
import me.rahulsengupta.news.core.db.entities.countrylist.ICountryListDb
import me.rahulsengupta.news.core.repository.countrylist.CountryListApi
import me.rahulsengupta.news.core.repository.countrylist.CountryRepository
import me.rahulsengupta.news.core.repository.countrylist.ICountryListApi
import me.rahulsengupta.news.core.repository.countrylist.ICountryRepository
import me.rahulsengupta.news.core.retrofit.RetrofitFactory.createCountryRetrofitClient
import me.rahulsengupta.news.core.retrofit.RetrofitFactory.createNewsRetrofitClient
import me.rahulsengupta.news.home.HomeApi
import me.rahulsengupta.news.home.HomeApiImpl
import me.rahulsengupta.news.home.HomeAvm
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DependencyInjectionModules {

    val homeFragment = module {
        single<HomeApi> { HomeApiImpl(get()) }
        viewModel { HomeAvm() }
    }

    val appModule = module {
        single { createCountryRetrofitClient() }
        single { createNewsRetrofitClient() }
        single { initializeDatabase(get()) }
        single<ICountryListApi> { CountryListApi(get()) }
        single<ICountryListDb> { CountryListDb(get<NewsDb>().countryListDao()) }
        single<ICountryRepository> { CountryRepository(get()) }
    }
}