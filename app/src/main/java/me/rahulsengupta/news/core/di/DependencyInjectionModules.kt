package me.rahulsengupta.news.core.di

import me.rahulsengupta.news.core.db.NewsDb
import me.rahulsengupta.news.core.db.RoomFactory.initializeDatabase
import me.rahulsengupta.news.core.db.entities.countrylist.CountryListDb
import me.rahulsengupta.news.core.db.entities.countrylist.ICountryListDb
import me.rahulsengupta.news.core.repository.countrylist.CountryListApi
import me.rahulsengupta.news.core.repository.countrylist.CountryRepository
import me.rahulsengupta.news.core.repository.countrylist.ICountryListApi
import me.rahulsengupta.news.core.repository.countrylist.ICountryRepository
import me.rahulsengupta.news.core.repository.sharedprefs.SharedPrefsRepositoryImpl
import me.rahulsengupta.news.core.repository.sharedprefs.ISharedPrefsRepository
import me.rahulsengupta.news.core.retrofit.RetrofitFactory.createCountryRetrofitClient
import me.rahulsengupta.news.core.retrofit.RetrofitFactory.createIconFinderRetrofitClient
import me.rahulsengupta.news.core.retrofit.RetrofitFactory.createNewsRetrofitClient
import me.rahulsengupta.news.home.HomeAvm
import me.rahulsengupta.news.home.api.HomeApi
import me.rahulsengupta.news.home.api.HomeApiImpl
import me.rahulsengupta.news.home.api.IconFinderApi
import me.rahulsengupta.news.home.api.IconFinderApiImpl
import me.rahulsengupta.news.settings.SettingsAvm
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DependencyInjectionModules {

    val homeFragmentModule = module {
        single<HomeApi> { HomeApiImpl() }
        single<IconFinderApi> { IconFinderApiImpl() }
        viewModel { HomeAvm() }
    }

    val settingsFragmentModule = module {
        viewModel { SettingsAvm() }
    }

    val appModule = module {
        single { createCountryRetrofitClient() }
        single { createNewsRetrofitClient() }
        single { initializeDatabase(get()) }
        single { createIconFinderRetrofitClient() }
        single<ISharedPrefsRepository> { SharedPrefsRepositoryImpl() }
    }

    val countryModule = module {
        single<ICountryListApi> { CountryListApi(get()) }
        single<ICountryListDb> { CountryListDb(get<NewsDb>().countryListDao()) }
        single<ICountryRepository> { CountryRepository(get()) }
    }
}