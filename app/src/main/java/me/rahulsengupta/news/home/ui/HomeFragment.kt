package me.rahulsengupta.news.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import me.rahulsengupta.news.R
import me.rahulsengupta.news.core.repository.countrylist.ICountryRepository
import me.rahulsengupta.news.home.HomeAvm
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeAvm: HomeAvm by viewModel()
    private val countryRepository: ICountryRepository by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        countryRepository.getCountries().observe(this, Observer {
            Toast.makeText(context, "${it.size}", Toast.LENGTH_SHORT).show()
        })

        countryRepository.fetchCountries()
        homeAvm.setup()
    }

}
