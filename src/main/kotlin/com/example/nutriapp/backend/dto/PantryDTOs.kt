package com.example.nutriapp.backend.dto

data class PantryDTO(
    val id: Int?,
    val name: String,
    val ownerId: Int,
    val items: List<PantryItemDTO>,
    val access: List<Int> // userIds
)

data class PantryItemDTO(
    val type: String,
    val itemId: Int?,
    val quantity: Double,
    val expirationDate: String?
)