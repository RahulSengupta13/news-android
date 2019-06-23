package me.rahulsengupta.news.core.repository.countrylist

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.rahulsengupta.news.core.coroutine.SafeCoroutineScope
import me.rahulsengupta.news.core.db.entities.countrylist.CountryEntity
import me.rahulsengupta.news.core.db.entities.countrylist.ICountryListDb
import me.rahulsengupta.news.core.retrofit.RetrofitResult
import org.koin.core.KoinComponent
import org.koin.core.inject

interface ICountryRepository {
    fun updateCountries(countryEntities: List<CountryEntity>)
    fun getSelectedCountry(): LiveData<CountryEntity>
    fun getCountries(): LiveData<List<CountryEntity>>
    fun fetchCountries()
}

class CountryRepository(context: Context) : ICountryRepository, SafeCoroutineScope(context), KoinComponent {

    private val countryListApi: ICountryListApi by inject()
    private val countryListDb: ICountryListDb by inject()

    private val countryListLiveData = MutableLiveData<List<CountryEntity>>()
    private val selectedCountryLiveData = MutableLiveData<CountryEntity>()

    init {
        launch(Dispatchers.IO) {
            countryListDb.getSelectedCountry()?.let { selectedCountryLiveData.postValue(it) }
        }
    }

    override fun getSelectedCountry() = selectedCountryLiveData

    override fun getCountries() = countryListLiveData

    override fun updateCountries(countryEntities: List<CountryEntity>) {
        launch(Dispatchers.IO) {
            countryListDb.saveCountries(countryEntities)
            countryListDb.getSelectedCountry()?.let { selectedCountryLiveData.postValue(it) }
        }
    }

    override fun fetchCountries() {
        launch(Dispatchers.IO) {
            val localCountryList = countryListDb.fetchAllCountries()
            if (localCountryList.isNullOrEmpty()) {
                when (val response = countryListApi.fetchCountries()) {
                    is RetrofitResult.SuccessfulResult -> {
                        response.body
                            .map { CountryEntity(it.alpha2Code, it.alpha3Code, it.name, it.flag) }
                            .also {
                                countryListLiveData.postValue(it)
                                countryListDb.saveCountries(it)
                            }
                    }
                    else -> Unit
                }
            } else {
                countryListLiveData.postValue(localCountryList)
            }
        }

    }
}