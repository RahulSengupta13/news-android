package me.rahulsengupta.news.home

import me.rahulsengupta.news.core.logic.BaseLogic
import me.rahulsengupta.news.core.retrofit.RetrofitResult
import org.koin.core.inject
import timber.log.Timber

class HomeLogic(listener: Listener) : BaseLogic() {

    interface Listener

    private val homeApi: HomeApi by inject()

    fun setup() {
        when (val response = homeApi.getCountryList()) {
            is RetrofitResult.SuccessfulResult -> {
                Timber.d(response.body.toString())
            }
            else -> {
                Timber.d(response.toString())
            }
        }
    }
}