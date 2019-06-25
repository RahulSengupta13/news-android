package me.rahulsengupta.news.home

import me.rahulsengupta.news.core.logic.BaseLogic
import me.rahulsengupta.news.core.retrofit.RetrofitResult
import org.koin.core.inject
import timber.log.Timber

class HomeLogic(listener: Listener) : BaseLogic() {

    interface Listener

    private val homeApi: HomeApi by inject()

    fun setup() {
        when (val response = homeApi.getTopHeadlines("us")) {
            is RetrofitResult.SuccessfulResult -> {
                Timber.d("Top Headlines: ${response.body.totalResults}")
            }
            is RetrofitResult.ErrorResult -> {
                Timber.d("Top Headlines: ${response.response}")
            }
        }
    }
}