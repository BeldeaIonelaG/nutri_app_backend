package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.AlimentDTO
import com.example.nutriapp.backend.dto.CompositionAlimentDTO
import com.example.nutriapp.backend.entity.AlimentEntity
import com.example.nutriapp.backend.entity.CompositionAlimentEntity

fun AlimentEntity.toDTO(): AlimentDTO =
    AlimentDTO(
        id = id,
        name = name,
        description = description,
        type = type,
        nutrients = compositions.map { it.toDTO() },
        updatedAt = updatedAt
    )

fun CompositionAlimentEntity.toDTO(): CompositionAlimentDTO =
    CompositionAlimentDTO(
        id = id,
        idNutrient = nutrient.id,
        amountPer100g = amountPer100g
    )