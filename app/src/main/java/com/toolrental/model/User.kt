package com.toolrental.model

data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val rating: Float = 0.0f,
    val profilePictureUrl: String = ""
)
