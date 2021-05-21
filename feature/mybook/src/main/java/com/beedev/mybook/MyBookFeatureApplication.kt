package com.beedev.mybook

import android.app.Application
import com.beedev.core.di.sharedModule
import com.beedev.mybook.di.myBookModule

class MyBookFeatureApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        org.koin.core.context.startKoin {
            applicationContext
            modules(sharedModule, myBookModule)
        }
    }
}