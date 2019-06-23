package me.rahulsengupta.news.core.db.entities.countrylist

interface ICountryListDb {
    fun saveCountries(entities: List<CountryEntity>)
    fun fetchAllCountries(): List<CountryEntity>
    fun getSelectedCountry(): CountryEntity?
}

class CountryListDb(private val dao: CountryListDao) : ICountryListDb {
    override fun saveCountries(entities: List<CountryEntity>) = dao.saveCountries(entities)
    override fun fetchAllCountries() = dao.fetchAllCountries()
    override fun getSelectedCountry() = dao.getSelectedCountry()
}
