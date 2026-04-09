package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.CompositionRecipeDTO
import com.example.nutriapp.backend.dto.IngredientDTO
import com.example.nutriapp.backend.dto.RecipeDTO
import com.example.nutriapp.backend.entity.CompositionRecipeEntity
import com.example.nutriapp.backend.entity.IngredientEntity
import com.example.nutriapp.backend.entity.IngredientId
import com.example.nutriapp.backend.entity.RecipeEntity
import java.time.LocalDateTime

fun RecipeEntity.toDTO(): RecipeDTO =
    RecipeDTO(
        id = id,
        name = name,
        description = description,
        instructions = instructions,
        servings = servings,
        difficultyLevel = difficultyLevel,
        typeM = typeM,

        creationDate = creationDate,
        idCookbook = idCookbook,
        idCreator = idCreator,
        idInitialCreator = idInitialCreator,
        previousRecipeId = previousRecipeId,

        updatedAt = updatedAt,

        nutrients = compositions.map { it.toDTO() },
        ingredients = ingredients.map { it.toDTO() }
    )

fun CompositionRecipeEntity.toDTO(): CompositionRecipeDTO =
    CompositionRecipeDTO(
        idNutrient = nutrient.id,
        amountPer100g = amountPer100g
    )

fun IngredientEntity.toDTO(): IngredientDTO =
    IngredientDTO(
        targetId = id.targetId,
        targetType = id.targetType,
        quantity = quantity,
        measurementUnit = measurementUnit
    )
