package me.rahulsengupta.news.home.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.rahulsengupta.news.R
import me.rahulsengupta.news.home.HomeAvm
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val homeAvm: HomeAvm by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeAvm.setup()
    }
}
