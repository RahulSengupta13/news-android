package me.rahulsengupta.news.home

import me.rahulsengupta.news.core.logic.BaseLogic
import org.koin.core.inject

class HomeLogic(listener: Listener) : BaseLogic() {

    interface Listener

    private val homeApi: HomeApi by inject()

    fun setup() {

    }
}