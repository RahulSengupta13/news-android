package me.rahulsengupta.news.home.ui

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_home.view.*
import me.rahulsengupta.news.R
import me.rahulsengupta.news.home.models.NewsViewModel

class HomePresenter {

    interface Listener {
        fun onSwipeToRefresh()
    }

    class Container(root: View, listener: Listener) {
        private val root: ConstraintLayout = root.home_fragment_root
        private val topHeadlinesRecyclerView: RecyclerView = root.top_headlines_recycler_view

        val topHeadlinesAdapter: TopHeadlinesPagedAdapter
        val swipeToRefresh: SwipeRefreshLayout = root.swipe_refresh

        init {
            topHeadlinesRecyclerView.apply {
                layoutManager = LinearLayoutManager(root.context, RecyclerView.VERTICAL, false)
                setHasFixedSize(true)
            }

            topHeadlinesAdapter = TopHeadlinesPagedAdapter(listener)
            topHeadlinesRecyclerView.adapter = topHeadlinesAdapter
            swipeToRefresh.setProgressBackgroundColorSchemeColor(root.context.getColor(R.color.offWhite))
            swipeToRefresh.setColorSchemeColors(root.context.getColor(R.color.blue))
            swipeToRefresh.setOnRefreshListener { listener.onSwipeToRefresh() }
        }
    }

    companion object {
        fun presentTopHeadlines(container: Container, topHeadlines: PagedList<NewsViewModel>) {
            container.topHeadlinesAdapter.submitList(topHeadlines)
            container.swipeToRefresh.isRefreshing = false
        }
    }
}