package me.rahulsengupta.network

import me.rahulsengupta.network.responses.CountryResponse
import retrofit2.Call
import retrofit2.http.GET

interface CountryEndpoints {

    @GET(" ")
    fun getCountryList(): Call<List<CountryResponse>>
}