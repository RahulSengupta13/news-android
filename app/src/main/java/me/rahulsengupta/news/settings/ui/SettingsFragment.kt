package me.rahulsengupta.news.settings.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_settings.view.*
import me.rahulsengupta.news.R
import me.rahulsengupta.news.core.ui.BaseFragment
import me.rahulsengupta.news.settings.SettingsAvm
import org.koin.android.ext.android.inject

class SettingsFragment : BaseFragment(), SettingsPresenter.Listener {

    private val _settingsAvm: SettingsAvm by inject()
    private lateinit var _presenterContainer: SettingsPresenter.Container

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_settings, container, false)

        val toolbar = view.toolbar_settings
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(activity as AppCompatActivity, findNavController())

        _presenterContainer = SettingsPresenter.Container(view, this)

        _settingsAvm.present().observe(this, Observer { SettingsPresenter.present(_presenterContainer, it) })

        _settingsAvm.setup()

        return view
    }
}