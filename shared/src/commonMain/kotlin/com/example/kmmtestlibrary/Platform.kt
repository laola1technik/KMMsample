package com.example.kmmtestlibrary

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform