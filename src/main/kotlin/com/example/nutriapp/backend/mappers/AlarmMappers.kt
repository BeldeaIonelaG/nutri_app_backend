package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.AlarmDTO
import com.example.nutriapp.backend.entity.AlarmEntity

fun AlarmEntity.toDTO(): AlarmDTO =
    AlarmDTO(
        id = id,
        description = description,
        eventId = eventId,
        userId = userId
    )

fun AlarmDTO.toEntity(): AlarmEntity =
    AlarmEntity(
        id = id ?: 0,
        description = description,
        eventId = eventId,
        userId = userId
    )