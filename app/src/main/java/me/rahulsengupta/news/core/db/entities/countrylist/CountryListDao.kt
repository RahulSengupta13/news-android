package me.rahulsengupta.news.core.db.entities.countrylist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryListDao {

    @Query("SELECT * FROM COUNTRY_TABLE ORDER BY $COUNTRY_TABLE.name")
    fun fetchAllCountries(): List<CountryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCountries(countryEntities: List<CountryEntity>)

    @Query("SELECT * FROM COUNTRY_TABLE WHERE $COUNTRY_TABLE.isSelected = 1")
    fun getSelectedCountry(): CountryEntity?
}