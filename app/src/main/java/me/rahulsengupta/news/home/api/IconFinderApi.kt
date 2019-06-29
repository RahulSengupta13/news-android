package me.rahulsengupta.news.home.api

import me.rahulsengupta.network.IconFinderEndpoints
import me.rahulsengupta.network.responses.IconFinderResponse
import me.rahulsengupta.news.core.retrofit.RetrofitResult
import me.rahulsengupta.news.core.retrofit.getRetrofitResult
import org.koin.core.KoinComponent
import org.koin.core.inject

interface IconFinderApi {
    fun getIcons(url: String): RetrofitResult<IconFinderResponse>
}

class IconFinderApiImpl : IconFinderApi, KoinComponent {

    private val iconFinderEndpoints: IconFinderEndpoints by inject()

    override fun getIcons(url: String) = iconFinderEndpoints.getIcons(url).getRetrofitResult()
}