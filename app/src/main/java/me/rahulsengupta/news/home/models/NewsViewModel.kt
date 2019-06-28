package me.rahulsengupta.news.home.models

data class NewsViewModel(
    val title: String,
    val description: String,
    val urlToImage: String,
    val sourceName: String,
    val urlToArticle: String,
    val publishedAt: String,
    var sourceId: String? = null,
    var sourceImageUrl: String? = null
)