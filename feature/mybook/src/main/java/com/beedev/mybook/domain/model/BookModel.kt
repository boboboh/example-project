package com.beedev.mybook.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookModel(
    @SerialName("title")
    val title: String? = null,
    @SerialName("price")
    val price: String? = null,
    @SerialName("image")
    val image: String? = null
)