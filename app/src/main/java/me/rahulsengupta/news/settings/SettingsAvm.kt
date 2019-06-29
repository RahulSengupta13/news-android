package me.rahulsengupta.news.settings

import androidx.lifecycle.MutableLiveData
import me.rahulsengupta.news.core.coroutine.ScopedViewModel
import me.rahulsengupta.news.settings.models.SettingsViewModel

class SettingsAvm : ScopedViewModel() {

    private val _businessLogic: SettingsLogic
    private val _present = MutableLiveData<SettingsViewModel>()

    init {
        val listener = object : SettingsLogic.Listener {
            override fun present(settingsViewModel: SettingsViewModel) = _present.postValue(settingsViewModel)

        }

        _businessLogic = SettingsLogic(listener)
    }

    /**
     * Observables
     * */
    fun present() = _present

    /**
     * Actionables
     * */
    fun setup() = _businessLogic.setup()
}