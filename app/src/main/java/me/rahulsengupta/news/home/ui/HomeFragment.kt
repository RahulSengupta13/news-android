package me.rahulsengupta.news.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import me.rahulsengupta.news.R
import me.rahulsengupta.news.core.repository.countrylist.ICountryRepository
import me.rahulsengupta.news.home.HomeAvm
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), HomePresenter.Listener {

    private val homeAvm: HomeAvm by viewModel()
    private val countryRepository: ICountryRepository by inject()

    private lateinit var _presenterContainer: HomePresenter.Container

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        _presenterContainer = HomePresenter.Container(root, this)

        homeAvm.topHeadlinesPagedList()
            .observe(this, Observer { HomePresenter.presentTopHeadlines(_presenterContainer, it) })
        homeAvm.setSourceIcon().observe(this, Observer {
            HomePresenter.setSourceIcon(_presenterContainer, it)
        })

        countryRepository.fetchCountries()
        homeAvm.setup()

        return root
    }

    override fun loadSourceImage(sourceDomain: String, sourceId: String?, position: Int) {
        homeAvm.loadSourceImage(sourceDomain, sourceId, position)
    }

    override fun onSwipeToRefresh() {
        homeAvm.onSwipeToRefresh()
    }
}
