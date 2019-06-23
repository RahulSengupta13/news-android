package me.rahulsengupta.news.core.repository.countrylist

import me.rahulsengupta.network.CountryEndpoints
import me.rahulsengupta.network.responses.CountryResponse
import me.rahulsengupta.news.core.retrofit.RetrofitResult
import me.rahulsengupta.news.core.retrofit.getRetrofitResult

interface ICountryListApi {
    fun fetchCountries(): RetrofitResult<List<CountryResponse>>
}

class CountryListApi(private val countryEndpoints: CountryEndpoints) : ICountryListApi {
    override fun fetchCountries() = countryEndpoints.getCountryList().getRetrofitResult()
}