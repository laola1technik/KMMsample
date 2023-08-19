package com.example.kmmtestlibrary

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface Api {
    suspend fun menu(menuName: String, language: String): Result<List<MenuItem>>
}

open class ApiClient(private val baseUrl: String) : Api {

    private val httpClient = HttpClient(engine = getPlatform().httpClientEngine) {
        install(Logging)
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun menu(menuName: String, language: String): Result<List<MenuItem>> {
        val url = "$baseUrl/menu?menuName=$menuName&language=$language"
        return try {
            val response = httpClient.get(url).body<List<MenuItem>>()
            Result.success(response)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}
