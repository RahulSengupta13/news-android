package me.rahulsengupta.news.core.coroutine

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * When using this class, please make sure to add to lifecycle with lifecycle.addObserver(...)
 *
 * @throws UninitializedPropertyAccessException when not added to lifecycle
 */
class LifecycleAwareCoroutineScope(context: Context) : BaseCoroutine(context), LifecycleObserver {

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = super.coroutineContext + job + Dispatchers.Main

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onCreate() {
        job = Job()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() = job.cancel()

}