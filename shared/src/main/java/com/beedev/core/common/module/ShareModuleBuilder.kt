package com.beedev.core.common.module

import android.content.Context

class ShareModuleBuilder(val context: Context) {
    fun build() {
        ShareModule.build(this)
    }
}