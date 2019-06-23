package me.rahulsengupta.news.home

import me.rahulsengupta.network.NewsEndpoints

interface HomeApi {
}

class HomeApiImpl(val newsEndpoints: NewsEndpoints) : HomeApi {

}