package com.example.nutriapp.backend.dto

data class NutrientDTO(
    val id: Int,
    val name: String,
    val description: String,
    val type: String,
    val measurementUnit: String
)
