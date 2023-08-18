package com.example.kmmtestlibrary

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class JsonFeedLoader(private val httpClient: HttpClient) {

    suspend fun loadJsonFeed(url: String): Result<List<MenuItem>> {
        return try {
            val response = httpClient.get(url).body<List<MenuItem>>()

            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}

data class FeedItem(val title: String, val description: String, val link: String)






