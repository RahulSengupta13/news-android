package me.rahulsengupta.news.home

import me.rahulsengupta.network.responses.TopHeadlinesResponse
import me.rahulsengupta.news.core.logic.BaseLogic
import me.rahulsengupta.news.core.retrofit.RetrofitResult
import me.rahulsengupta.news.home.api.HomeApi
import me.rahulsengupta.news.home.api.IconFinderApi
import me.rahulsengupta.news.home.models.HomeState
import me.rahulsengupta.news.home.models.NewsViewModel
import me.rahulsengupta.news.home.models.SourceIconPayload
import org.joda.time.DateTime
import org.joda.time.Duration
import org.joda.time.Hours
import org.koin.core.inject

class HomeLogic(private val listener: Listener) : BaseLogic() {

    interface Listener {
        fun setSourceIcon(sourceIconPayload: SourceIconPayload)
    }

    private val homeApi: HomeApi by inject()
    private val iconFinderApi: IconFinderApi by inject()
    private var homeState = HomeState()

    fun setup() {
        homeApi.getNewsSources().run {
            when (this) {
                is RetrofitResult.SuccessfulResult -> {
                    homeState = homeState.copy(sources = body.sources)
                }
                is RetrofitResult.ErrorResult -> Unit
            }
        }
    }

    fun loadSourceImage(sourceDomain: String, sourceId: String?, position: Int) {
        val sourceUrl = homeState.sources?.firstOrNull { it.id == sourceId }?.url ?: sourceDomain

        iconFinderApi.getIcons(sourceUrl).run {
            when (this) {
                is RetrofitResult.SuccessfulResult -> {
                    listener.setSourceIcon(SourceIconPayload(body.icons.first().url, position))
                }
                is RetrofitResult.ErrorResult -> Unit
            }

        }
    }

    companion object {

        fun toNewsViewModel(newsList: List<TopHeadlinesResponse.Article>?) = newsList
            ?.filter { !it.description.isNullOrEmpty() && !it.urlToImage.isNullOrEmpty() && !it.url.isNullOrEmpty() }
            ?.map { article ->
                NewsViewModel(
                    article.title ?: "",
                    article.description ?: "",
                    article.urlToImage ?: "",
                    article.source?.name ?: "",
                    article.url ?: "",
                    article.publishedAt?.let {
                        "${Hours.standardHoursIn(
                            Duration(
                                DateTime.now(),
                                DateTime.parse(it)
                            ).toStandardHours()
                        )} ago"
                    } ?: "",
                    article.source?.id ?: ""
                )
            } ?: listOf()
    }
}