package me.rahulsengupta.network

import me.rahulsengupta.network.responses.SourceResponse
import me.rahulsengupta.network.responses.TopHeadlinesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsEndpoints {

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("country") country: String? = null
    ): Call<TopHeadlinesResponse>

    @GET("sources")
    fun getNewsSources(): Call<SourceResponse>
}