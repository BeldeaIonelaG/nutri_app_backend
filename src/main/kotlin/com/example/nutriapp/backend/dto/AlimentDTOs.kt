package com.example.nutriapp.backend.dto

data class CompositionAlimentDTO(
    val id: Int?,
    val idNutrient: Int,
    val amountPer100g: Double
)

data class AlimentDTO(
    val id: Int?,
    val name: String,
    val description: String,
    val type: String,
    val nutrients: List<CompositionAlimentDTO>
)