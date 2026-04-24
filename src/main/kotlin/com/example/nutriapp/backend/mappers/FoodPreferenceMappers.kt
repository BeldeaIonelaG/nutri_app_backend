package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.FoodPreferenceDTO
import com.example.nutriapp.backend.entity.FoodPreferenceEntity

fun FoodPreferenceEntity.toDTO() =
    FoodPreferenceDTO(
        id = id,
        userId = userId,
        type = type,
        targetType = targetType,
        targetId = targetId
    )

fun FoodPreferenceDTO.toEntity() =
    FoodPreferenceEntity(
        id = id ?: 0,
        userId = userId,
        type = type,
        targetType = targetType,
        targetId = targetId
    )