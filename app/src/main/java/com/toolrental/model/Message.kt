package com.toolrental.model

import java.util.Date

data class Message(
    val id: String = "",
    val senderId: String = "",
    val text: String = "",
    val timestamp: Date = Date()
)
