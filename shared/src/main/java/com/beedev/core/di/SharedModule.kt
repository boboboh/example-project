package com.beedev.core.di

import com.beedev.core.network.createNetworkClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sharedModule = module {
    single(named("Retrofit")) {
        createNetworkClient()
    }
}