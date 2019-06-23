package me.rahulsengupta.news.core.retrofit

import me.rahulsengupta.news.core.retrofit.models.NoContentResponse
import me.rahulsengupta.news.core.retrofit.models.RetrofitResult
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import java.net.HttpURLConnection

fun <T> Call<T>.getRetrofitResult(defaultErrorMessage: String = "Error"): RetrofitResult<T> {
    return try {
        val response = execute()
        if (isSuccessful(response.code())) {
            val body = response.body()
            when {
                body != null -> RetrofitResult.SuccessfulResult(body)
                response.code() == HttpURLConnection.HTTP_NO_CONTENT -> RetrofitResult.SuccessfulResult(
                    NoContentResponse() as T
                )
                else -> {
                    toRetrofitResult(defaultErrorMessage, response)
                }
            }
        } else {
            val errorString = response.errorBody()?.string()
            toRetrofitResult(errorString ?: defaultErrorMessage, response)
        }
    } catch (e: Exception) {
        Timber.e(e)
        toRetrofitResult(defaultErrorMessage, null)
    }
}

fun isSuccessful(code: Int): Boolean {
    return code in 200..299
}

fun <R> toRetrofitResult(defaultErrorMessage: String = "", response: Response<*>?): RetrofitResult.ErrorResult<R> {
    return RetrofitResult.ErrorResult(defaultErrorMessage, response)
}