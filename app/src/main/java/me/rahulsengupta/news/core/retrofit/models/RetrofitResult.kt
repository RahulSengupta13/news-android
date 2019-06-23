package me.rahulsengupta.news.core.retrofit.models

import retrofit2.Response
import java.io.Serializable

sealed class RetrofitResult<out T> : Serializable {

    data class ErrorResult<out T>(
        val message: String,
        val response: Response<*>? = null
    ) : RetrofitResult<T>()

    data class SuccessfulResult<out T>(
        val body: T
    ) : RetrofitResult<T>()

}