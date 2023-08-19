package com.example.kmmtestlibrary

import io.ktor.client.engine.HttpClientEngine

interface Platform {
    val name: String
    val httpClientEngine: HttpClientEngine
}

expect fun getPlatform(): Platform

