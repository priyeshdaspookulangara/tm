package com.toolrental.model

import java.util.Date

data class Booking(
    val id: String = "",
    val toolId: String = "",
    val renterId: String = "",
    val ownerId: String = "",
    val bookingDate: Date = Date(),
    val status: String = ""
)
