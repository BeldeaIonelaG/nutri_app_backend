package com.example.nutriapp.backend.dto

data class IntakeDTO(
    val id: Int?,
    val foodType: String,
    val foodId: Int,
    val quantity: Double,
    val measurementUnit: String,
    val dateTime: String,
    val userId: Int,
    val nutrients: List<NutrientIntakeDTO>
)

data class NutrientIntakeDTO(
    val nutrientId: Int,
    val quantity: Double
)