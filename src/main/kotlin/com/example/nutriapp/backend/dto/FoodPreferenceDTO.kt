package com.example.nutriapp.backend.dto

data class FoodPreferenceDTO(
    val id: Int?,
    val userId: Int,
    val type: String,
    val targetType: String,
    val targetId: Int
)