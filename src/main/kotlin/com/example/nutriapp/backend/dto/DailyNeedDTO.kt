package com.example.nutriapp.backend.dto

data class DailyNeedDTO(
    val userId: Int,
    val nutrientId: Int,
    val quantity: Double
)