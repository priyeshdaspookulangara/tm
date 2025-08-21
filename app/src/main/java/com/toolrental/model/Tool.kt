package com.toolrental.model

data class Tool(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val brand: String = "",
    val pricePerDay: Double = 0.0,
    val pricePerWeek: Double = 0.0,
    val availability: List<String> = emptyList(),
    val ownerId: String = "",
    val images: List<String> = emptyList()
)
