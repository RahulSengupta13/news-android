package me.rahulsengupta.news.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.top_headlines_item_layout.view.*
import me.rahulsengupta.news.R
import me.rahulsengupta.news.home.models.NewsViewModel
import me.rahulsengupta.news.home.ui.TopHeadlinesPagedAdapter.TopHeadlinesViewHolder

class TopHeadlinesPagedAdapter(val listener: HomePresenter.Listener) :
    PagedListAdapter<NewsViewModel, TopHeadlinesViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_headlines_item_layout, parent, false)
        return TopHeadlinesViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopHeadlinesViewHolder, position: Int) {
        getItem(position)?.run {
            holder.title.text = title
            holder.description.text = description
            Picasso.get().load(urlToImage).into(holder.image)
        }
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position

    class TopHeadlinesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.news_title
        val description: TextView = view.news_description
        val image: AppCompatImageView = view.news_image
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NewsViewModel>() {
            override fun areItemsTheSame(oldItem: NewsViewModel, newItem: NewsViewModel): Boolean {
                return oldItem.title === oldItem.title
            }

            override fun areContentsTheSame(oldItem: NewsViewModel, newItem: NewsViewModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}