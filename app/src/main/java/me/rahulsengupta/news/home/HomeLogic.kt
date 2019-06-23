package me.rahulsengupta.news.home

import me.rahulsengupta.news.core.retrofit.models.RetrofitResult
import timber.log.Timber

class HomeLogic(listener: Listener, private val homeApi: HomeApi) {

    interface Listener

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