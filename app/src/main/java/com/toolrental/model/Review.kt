package com.toolrental.model

data class Review(
    val id: String = "",
    val toolId: String = "",
    val ownerId: String = "",
    val renterId: String = "",
    val rating: Float = 0.0f,
    val text: String = ""
)
