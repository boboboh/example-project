package com.beedev.core.network

import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

class CustomHttpLogging : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        val logName = "HttpLogging"
        if (message.startsWith("{") || message.startsWith("[")) {
            try {
                val prettyPrintJson = GsonBuilder().setPrettyPrinting()
                    .create().toJson(message)
                Timber.tag(logName).d(prettyPrintJson)
            } catch (m: JsonSyntaxException) {
                Timber.tag(logName).d(message)
            }
        } else {
            Timber.tag(logName).d(message)
            return
        }
    }
}