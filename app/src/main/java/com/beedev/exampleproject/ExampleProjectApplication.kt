package com.beedev.exampleproject

import android.app.Application
import com.beedev.core.di.sharedModule
import com.beedev.mybook.di.myBookModule
import org.koin.core.context.startKoin
import timber.log.Timber

class ExampleProjectApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()


        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun startKoin() {
        startKoin {
            applicationContext
            modules(sharedModule, myBookModule)
        }
    }
}