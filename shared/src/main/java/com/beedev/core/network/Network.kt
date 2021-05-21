package com.beedev.core.network

import com.beedev.core.BuildConfig
import com.beedev.core.common.module.ShareModule
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun createNetworkClient() =
    retrofitClient(httpClient())

//class BasicAuthInterceptor() : Interceptor {
//
//    @Throws(IOException::class)
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request = chain.request()
//        val newUrl = request.url().newBuilder().addQueryParameter("apiKey", BuildConfig.API_KEY).build()
//        val newRequest = request.newBuilder().url(newUrl).build()
//        return chain.proceed(newRequest)
//    }
//
//}

private val collector = ChuckerCollector(
    context = ShareModule.getContext(),
    showNotification = true,
    retentionPeriod = RetentionManager.Period.ONE_HOUR
)

private val chuckerInterceptor = ChuckerInterceptor.Builder(ShareModule.getContext())
    .collector(collector)
    .maxContentLength(250000L)
    .redactHeaders(emptySet())
    .alwaysReadResponseBody(true)
    .build()


private fun httpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor(CustomHttpLogging())
    val clientBuilder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG_MODE) {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(httpLoggingInterceptor)
    }

    clientBuilder.addInterceptor(chuckerInterceptor)

    clientBuilder.readTimeout(120, TimeUnit.SECONDS)
    clientBuilder.writeTimeout(120, TimeUnit.SECONDS)
    return clientBuilder.build()
}

private fun retrofitClient(httpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BuildConfig.DOMAIN)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()