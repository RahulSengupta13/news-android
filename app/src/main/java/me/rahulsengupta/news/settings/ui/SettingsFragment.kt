package me.rahulsengupta.news.settings.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_settings.view.*
import me.rahulsengupta.news.R
import me.rahulsengupta.news.core.ui.BaseFragment

class SettingsFragment : BaseFragment(), SettingsPresenter.Listener {

    private lateinit var _presenterContainer: SettingsPresenter.Container

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_settings, container, false)

        val toolbar = view.toolbar_settings
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(activity as AppCompatActivity, findNavController())

        _presenterContainer = SettingsPresenter.Container(view, this)

        return view
    }
}