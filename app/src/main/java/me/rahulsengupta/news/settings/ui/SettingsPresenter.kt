package me.rahulsengupta.news.settings.ui

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.ahmadrosid.svgloader.SvgLoader
import kotlinx.android.synthetic.main.fragment_settings.view.*
import me.rahulsengupta.news.settings.models.SettingsViewModel

class SettingsPresenter {

    interface Listener

    class Container(val root: View, val listener: Listener) {
        private val countryView: View = root.settings_country_view
        val countryFlag: AppCompatImageView = root.settings_country_flag

        init {
            countryView.setOnClickListener { }
        }
    }

    companion object {

        fun present(container: Container, settingsViewModel: SettingsViewModel) {
            SvgLoader.pluck()
                .with(container.root.context as AppCompatActivity)
                .load(settingsViewModel.countryFlagUrl, container.countryFlag)
        }
    }
}