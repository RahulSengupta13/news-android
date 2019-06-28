package me.rahulsengupta.network

import me.rahulsengupta.network.responses.IconFinderResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IconFinderEndpoints {

    @GET("allicons.json")
    fun getIcons(@Query("url") url: String): Call<IconFinderResponse>
}