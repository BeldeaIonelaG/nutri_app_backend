package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.IntakeDTO
import com.example.nutriapp.backend.dto.NutrientIntakeDTO
import com.example.nutriapp.backend.entity.IntakeEntity
import com.example.nutriapp.backend.entity.NutrientIntakeEntity

fun IntakeEntity.toDTO(): IntakeDTO =
    IntakeDTO(
        id = id,
        foodType = foodType,
        foodId = foodId,
        quantity = quantity,
        measurementUnit = measurementUnit,
        dateTime = dateTime.toString(),
        userId = userId,
        nutrients = nutrients.map { it.toDTO() }
    )

fun NutrientIntakeEntity.toDTO(): NutrientIntakeDTO =
    NutrientIntakeDTO(
        nutrientId = nutrientId,
        quantity = quantity
    )