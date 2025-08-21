package com.toolrental.model

data class ToolCondition(
    val id: String = "",
    val toolId: String = "",
    val notes: String = "",
    val photos: List<String> = emptyList()
)
