package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.DailyNeedDTO
import com.example.nutriapp.backend.entity.DailyNeedEntity

fun DailyNeedEntity.toDTO() =
    DailyNeedDTO(userId, nutrientId, quantity)

fun DailyNeedDTO.toEntity() =
    DailyNeedEntity(userId, nutrientId, quantity)