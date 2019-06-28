package me.rahulsengupta.news.home.models

import me.rahulsengupta.network.responses.SourceResponse

data class HomeState(
    val sources: List<SourceResponse.Source>? = null
)