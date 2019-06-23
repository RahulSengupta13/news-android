package me.rahulsengupta.news.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.rahulsengupta.news.core.db.entities.countrylist.CountryEntity
import me.rahulsengupta.news.core.db.entities.countrylist.CountryListDao

@Database(
    entities = [CountryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDb : RoomDatabase() {
    abstract fun countryListDao(): CountryListDao
}