package me.rahulsengupta.news.core.db

import android.content.Context
import androidx.room.Room

object RoomFactory {

    fun initializeDatabase(context: Context): NewsDb {
        return Room.databaseBuilder(context, NewsDb::class.java, "newsDb").build()
    }
}