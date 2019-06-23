package me.rahulsengupta.news.home

import me.rahulsengupta.network.CountryEndpoints
import me.rahulsengupta.network.NewsEndpoints
import me.rahulsengupta.network.responses.CountryResponse
import me.rahulsengupta.news.core.retrofit.getRetrofitResult
import me.rahulsengupta.news.core.retrofit.RetrofitResult

interface HomeApi {
    fun getCountryList(): RetrofitResult<List<CountryResponse>>
}

class HomeApiImpl(private val countryEndpoints: CountryEndpoints, val newsEndpoints: NewsEndpoints) : HomeApi {
    override fun getCountryList() = countryEndpoints.getCountryList().getRetrofitResult()
}