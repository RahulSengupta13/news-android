package me.rahulsengupta.news.settings.models

import me.rahulsengupta.news.core.db.entities.countrylist.CountryEntity

data class SettingsState(
    val savedCountry: CountryEntity? = null
)