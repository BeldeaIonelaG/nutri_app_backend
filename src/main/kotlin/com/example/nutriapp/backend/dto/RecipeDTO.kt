package com.example.nutriapp.backend.dto

import java.time.LocalDate

data class CompositionRecipeDTO(
    val idNutrient: Int,
    val amountPer100g: Double
)

data class IngredientDTO(
    val targetId: Int,
    val targetType: String,
    val quantity: Double?,
    val measurementUnit: String?
)

data class RecipeDTO(
    val id: Int?,
    val name: String,
    val description: String?,
    val instructions: String?,
    val servings: Int?,
    val difficultyLevel: Int?,
    val typeM: String?,

    val creationDate: LocalDate?,
    val idCookbook: Int?,
    val idCreator: Int?,
    val idInitialCreator: Int?,
    val previousRecipeId: Int?,

    val updatedAt: Long,

    val nutrients: List<CompositionRecipeDTO>,
    val ingredients: List<IngredientDTO>
)