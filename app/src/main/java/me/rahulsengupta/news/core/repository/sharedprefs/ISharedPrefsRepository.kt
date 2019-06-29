package me.rahulsengupta.news.core.repository.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import org.koin.core.KoinComponent
import org.koin.core.inject

interface ISharedPrefsRepository {
    fun getSavedCountry(): String?
    fun setSavedCountry(country: String)
}

class SharedPrefsRepositoryImpl : ISharedPrefsRepository, KoinComponent {

    private val context: Context by inject()
    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(PREFS_NEWS, Context.MODE_PRIVATE)
    }

    override fun getSavedCountry(): String? = sharedPreferences.getString(PREFS_SAVED_COUNTRY, null)
    override fun setSavedCountry(country: String) = sharedPreferences.edit().putString(PREFS_SAVED_COUNTRY, country).apply()

    companion object {
        private const val PREFS_NEWS = "newsprefs"
        private const val PREFS_SAVED_COUNTRY = "SAVED_COUNTRY"
    }
}