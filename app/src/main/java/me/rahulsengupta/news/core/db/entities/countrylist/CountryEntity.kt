package me.rahulsengupta.news.core.db.entities.countrylist

import androidx.room.Entity
import androidx.room.PrimaryKey

const val COUNTRY_TABLE = "country_table"

@Entity(tableName = COUNTRY_TABLE)
data class CountryEntity(
    @PrimaryKey val alpha2Code: String,
    val alpha3Code: String,
    val name: String,
    val flag: String,
    val isSelected: Int = 0
)