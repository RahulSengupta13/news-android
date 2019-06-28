package me.rahulsengupta.news.home

import me.rahulsengupta.network.responses.TopHeadlinesResponse
import me.rahulsengupta.news.core.logic.BaseLogic
import me.rahulsengupta.news.home.models.NewsViewModel
import org.koin.core.inject

class HomeLogic(listener: Listener) : BaseLogic() {

    interface Listener

    private val homeApi: HomeApi by inject()

    fun setup() {

    }

    companion object {

        fun toNewsViewModel(newsList: List<TopHeadlinesResponse.Article>?) = newsList?.map {
            NewsViewModel(it.title ?: "", it.description ?: "", it.urlToImage ?: "")
        }?.filter { it.description.isNotEmpty() && it.urlToImage.isNotEmpty() } ?: listOf()
    }
}