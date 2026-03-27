package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.NutrientDTO
import com.example.nutriapp.backend.entity.NutrientEntity

fun NutrientEntity.toDTO(): NutrientDTO =
    NutrientDTO(
        id = id,
        name = name,
        description = description,
        type = type,
        measurementUnit = measurementUnit
    )

fun NutrientDTO.toEntity(): NutrientEntity =
    NutrientEntity(
        id = id,
        description = description,
        type = type,
        measurementUnit = measurementUnit,
        name = name
    )
