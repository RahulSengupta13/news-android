package me.rahulsengupta.news.settings

import me.rahulsengupta.news.core.logic.BaseLogic
import me.rahulsengupta.news.core.repository.countrylist.ICountryRepository
import me.rahulsengupta.news.core.repository.sharedprefs.ISharedPrefsRepository
import me.rahulsengupta.news.settings.models.SettingsState
import me.rahulsengupta.news.settings.models.SettingsViewModel
import org.koin.core.inject

class SettingsLogic(private val listener: Listener) : BaseLogic() {

    interface Listener {
        fun present(settingsViewModel: SettingsViewModel)
    }

    private val prefsRepository: ISharedPrefsRepository by inject()
    private val countryRepository: ICountryRepository by inject()

    private var settingsState = SettingsState()

    fun setup() {
        val savedCountry = prefsRepository.getSavedCountry()
        val countryList = countryRepository.getCountriesList()

        countryList
            ?.first { it.alpha2Code.equals(savedCountry, true) }
            ?.also {
                settingsState = settingsState.copy(savedCountry = it)
            }
        listener.present(stateToViewModel(settingsState))
    }

    companion object {

        fun stateToViewModel(settingsState: SettingsState): SettingsViewModel {
            return SettingsViewModel(
                settingsState.savedCountry?.flag
            )
        }
    }
}