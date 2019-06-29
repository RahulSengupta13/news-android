package me.rahulsengupta.news.settings.ui

import android.view.View
import kotlinx.android.synthetic.main.fragment_settings.view.*

class SettingsPresenter {

    interface Listener

    class Container(val root: View, val listener: Listener) {
        private val countryView: View = root.settings_country_view

        init {
            countryView.setOnClickListener {  }
        }
    }
}