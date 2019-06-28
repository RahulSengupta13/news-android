package me.rahulsengupta.news.home.models

import androidx.paging.PageKeyedDataSource
import me.rahulsengupta.news.core.retrofit.RetrofitResult
import me.rahulsengupta.news.home.HomeApi
import me.rahulsengupta.news.home.HomeLogic.Companion.toNewsViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class TopHeadlinesDataSource : PageKeyedDataSource<Int, NewsViewModel>(), KoinComponent {

    private val api: HomeApi by inject()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, NewsViewModel>) {
        api.getTopHeadlines(
            INITIAL_PAGE,
            PAGE_SIZE
        ).run {
            when (this) {
                is RetrofitResult.SuccessfulResult -> {
                    callback.onResult(toNewsViewModel(body.articles), null, INITIAL_PAGE + 1)
                }
                is RetrofitResult.ErrorResult -> Unit
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, NewsViewModel>) {
        api.getTopHeadlines(params.key, PAGE_SIZE).run {
            when (this) {
                is RetrofitResult.SuccessfulResult -> {
                    val adjacentKey = if (PAGE_SIZE > body.totalResults ?: 0) params.key + 1 else null
                    callback.onResult(toNewsViewModel(body.articles), adjacentKey)
                }
                is RetrofitResult.ErrorResult -> Unit
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, NewsViewModel>) {
        api.getTopHeadlines(params.key, PAGE_SIZE).run {
            when (this) {
                is RetrofitResult.SuccessfulResult -> {
                    val adjacentKey = if (params.key > 1) params.key - 1 else null
                    callback.onResult(toNewsViewModel(body.articles), adjacentKey)
                }
                is RetrofitResult.ErrorResult -> Unit
            }
        }
    }

    companion object {
        private const val INITIAL_PAGE = 1
        const val PAGE_SIZE = 50
    }
}