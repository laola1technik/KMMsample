package com.example.kmmtestlibrary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    val title: String? = null,
    val language: String? = null,
    val pageStyle: String? = null,
    val pageLayout: String? = null,
    val slug: String? = null,
    val icon: String? = null,
    @SerialName("link_type") val linkType: String? = null,
    val link: String? = null,
    val children: List<MenuItem>? = null
)