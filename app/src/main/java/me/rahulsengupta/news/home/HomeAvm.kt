package me.rahulsengupta.news.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.rahulsengupta.news.core.coroutine.ScopedViewModel
import me.rahulsengupta.news.home.models.NewsViewModel
import me.rahulsengupta.news.home.models.SourceIconPayload
import me.rahulsengupta.news.home.models.TopHeadlinesDataSource.Companion.PAGE_SIZE
import me.rahulsengupta.news.home.models.TopHeadlinesFactory

class HomeAvm : ScopedViewModel() {

    private val _logic: HomeLogic

    private val _topHeadlinesPagedListSource: MutableLiveData<PageKeyedDataSource<Int, NewsViewModel>>
    private val _topHeadlinesPagedList: LiveData<PagedList<NewsViewModel>>
    private val _setSourceIcon = MutableLiveData<SourceIconPayload>()

    init {
        val listener = object : HomeLogic.Listener {
            override fun setSourceIcon(sourceIconPayload: SourceIconPayload) = _setSourceIcon.postValue(sourceIconPayload)
        }
        _logic = HomeLogic(listener)

        val topHeadlinesFactory = TopHeadlinesFactory()
        _topHeadlinesPagedListSource = topHeadlinesFactory.getTopHeadlinesSource()

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_SIZE)
            .build()
        _topHeadlinesPagedList = LivePagedListBuilder(topHeadlinesFactory, pagedListConfig).build()
    }

    /**
     * Observables
     * */
    fun topHeadlinesPagedList() = _topHeadlinesPagedList
    fun setSourceIcon() = _setSourceIcon

    /**
     * Actionables
     * */
    fun setup() {
        coroutineScope.launch(Dispatchers.IO) { _logic.setup() }
    }
    fun loadSourceImage(sourceDomain: String, sourceId: String?, position: Int) {
        coroutineScope.launch(Dispatchers.IO) { _logic.loadSourceImage(sourceDomain, sourceId, position) }
    }
    fun onSwipeToRefresh() = _topHeadlinesPagedListSource.value?.invalidate()
}