package me.rahulsengupta.news.home

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.rahulsengupta.news.core.coroutine.ScopedViewModel

class HomeAvm : ScopedViewModel() {

    private val logic: HomeLogic

    init {
        val listener = object : HomeLogic.Listener {

        }
        logic = HomeLogic(listener)
    }

    fun setup() {
        coroutineScope.launch(Dispatchers.IO) { logic.setup() }
    }
}