package com.example.kmmtestlibrary

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    override val httpClientEngine: HttpClientEngine = OkHttp.create()
}

actual fun getPlatform(): Platform = AndroidPlatform()