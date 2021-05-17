package com.beedev.core.common

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BaseActivity(
    @LayoutRes contentLayoutId: Int
) : AppCompatActivity(contentLayoutId), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}