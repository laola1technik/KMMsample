package com.example.kmmtestlibrary

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertTrue

class JsonLoaderTest {

    @Test
    fun testMenuLoading() = runTest {

        val feedLoader = JsonFeedLoader(HttpClient{
            install(ContentNegotiation){
                json(Json{
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        })

        launch {
            val menuItems =
                feedLoader.loadJsonFeed("https://api.afc.dev.digitalservices.sportradar.com/v2/menu?menuName=MobileNavigation_v1.2.0&language=en")

            assertTrue(menuItems.isSuccess)
        }


    }


}