package com.example.kmmtestlibrary

import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class ApiClientTest {
    @Test
    fun shouldLoadMenu() = runTest {

        val client = ApiClient("https://api.afc.dev.digitalservices.sportradar.com/v2")

        launch {
            val menu = client.menu("MobileNavigation_v1.2.0", "en")
            assertTrue(menu.getOrNull()?.isNotEmpty() ?: false)
        }
    }
}