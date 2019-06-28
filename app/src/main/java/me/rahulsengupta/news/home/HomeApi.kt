package me.rahulsengupta.news.home

import me.rahulsengupta.network.NewsEndpoints
import me.rahulsengupta.network.responses.SourceResponse
import me.rahulsengupta.network.responses.TopHeadlinesResponse
import me.rahulsengupta.news.core.retrofit.RetrofitResult
import me.rahulsengupta.news.core.retrofit.getRetrofitResult
import org.koin.core.KoinComponent
import org.koin.core.inject

interface HomeApi {
    fun getTopHeadlines(page: Int, pageSize: Int, country: String? = "us"): RetrofitResult<TopHeadlinesResponse>
    fun getNewsSources(): RetrofitResult<SourceResponse>
}

class HomeApiImpl : HomeApi, KoinComponent {

    private val newsEndpoints: NewsEndpoints by inject()

    override fun getTopHeadlines(page: Int, pageSize: Int, country: String?)  = newsEndpoints.getTopHeadlines(page, pageSize, country).getRetrofitResult()
    override fun getNewsSources() = newsEndpoints.getNewsSources().getRetrofitResult()
}