package me.rahulsengupta.news.core.retrofit

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import me.rahulsengupta.network.CountryEndpoints
import me.rahulsengupta.network.IconFinderEndpoints
import me.rahulsengupta.network.NewsEndpoints
import me.rahulsengupta.news.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    private const val BASE_COUNTRY_URL = "https://restcountries.eu/rest/v2/"
    private const val BASE_NEWS_URL = "https://newsapi.org/v2/"
    private const val BASE_ICON_FINDER_URL = "https://besticon-demo.herokuapp.com/"

    fun createCountryRetrofitClient(): CountryEndpoints {
        val okHttpClient = OkHttpClient.Builder()

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        okHttpClient.apply { addInterceptor(loggingInterceptor) }

        return Retrofit.Builder()
            .baseUrl(BASE_COUNTRY_URL)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().disableHtmlEscaping().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(CountryEndpoints::class.java)
    }

    fun createNewsRetrofitClient(): NewsEndpoints {
        val okHttpClient = OkHttpClient.Builder()

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val headerAuthorizationInterceptor = Interceptor { chain ->
            val request = chain.request()
            val originalHttpUrl = request.url()

            val url = originalHttpUrl
                .newBuilder()
                .addQueryParameter("apiKey", BuildConfig.NewsOrgApiKey)
                .build()

            val requestBuilder = request.newBuilder().url(url)
            chain.proceed(requestBuilder.build())
        }

        okHttpClient.apply {
            addInterceptor(headerAuthorizationInterceptor)
            addInterceptor(loggingInterceptor)
        }

        return Retrofit.Builder()
            .baseUrl(BASE_NEWS_URL)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().disableHtmlEscaping().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(NewsEndpoints::class.java)
    }

    fun createIconFinderRetrofitClient(): IconFinderEndpoints {
        val okHttpClient = OkHttpClient.Builder()

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        okHttpClient.apply {
            addInterceptor(loggingInterceptor)
        }

        return Retrofit.Builder()
            .baseUrl(BASE_ICON_FINDER_URL)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().disableHtmlEscaping().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(IconFinderEndpoints::class.java)
    }
}