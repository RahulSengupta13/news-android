package me.rahulsengupta.news.home.models

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import org.koin.core.KoinComponent

class TopHeadlinesFactory : DataSource.Factory<Int, NewsViewModel>(), KoinComponent {

    private val _topHeadlinesSource = MutableLiveData<PageKeyedDataSource<Int, NewsViewModel>>()

    override fun create(): DataSource<Int, NewsViewModel> {
        val topHeadlinesDataSource = TopHeadlinesDataSource()
        _topHeadlinesSource.postValue(topHeadlinesDataSource)
        return topHeadlinesDataSource
    }

    fun getTopHeadlinesSource() = _topHeadlinesSource
}