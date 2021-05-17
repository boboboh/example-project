package com.beedev.core.common.module

import android.content.Context

class ShareModule private constructor() {
    companion object {

        @Volatile
        private var shareModuleFacade: ShareModuleFacade = EmptyShareModule()

        @Synchronized
        fun init(context: Context): ShareModuleBuilder {
            return ShareModuleBuilder(context)
        }

        fun build(shareModuleBuilder: ShareModuleBuilder) {
            shareModuleFacade = DefaultShareModule(shareModuleBuilder)
        }

        fun getContext(): Context = shareModuleFacade.getContext()
    }
}