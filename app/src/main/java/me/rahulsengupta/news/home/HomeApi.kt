package me.rahulsengupta.news.home

import me.rahulsengupta.network.NewsEndpoints
import me.rahulsengupta.network.responses.TopHeadlinesResponse
import me.rahulsengupta.news.core.retrofit.RetrofitResult
import me.rahulsengupta.news.core.retrofit.getRetrofitResult
import org.koin.core.KoinComponent
import org.koin.core.inject

interface HomeApi {
    fun getTopHeadlines(country: String?): RetrofitResult<TopHeadlinesResponse>
}

class HomeApiImpl : HomeApi, KoinComponent {

    private val newsEndpoints: NewsEndpoints by inject()

    override fun getTopHeadlines(country: String?): RetrofitResult<TopHeadlinesResponse> =
        newsEndpoints.getTopHeadlines(country).getRetrofitResult()
}