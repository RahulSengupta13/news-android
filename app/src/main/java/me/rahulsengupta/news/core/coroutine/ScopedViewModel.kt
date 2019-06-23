package me.rahulsengupta.news.core.coroutine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import timber.log.Timber

open class ScopedViewModel(application: Application) : AndroidViewModel(application) {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Timber.e(throwable)
    }

    private val job = Job()

    protected val coroutineScope: CoroutineScope
        get() = CoroutineScope(job + coroutineExceptionHandler + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}