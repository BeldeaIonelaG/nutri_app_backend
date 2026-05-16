package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.UserPreviewDTO
import com.example.nutriapp.backend.entity.UserEntity

fun UserEntity.toPreviewDTO() =
    UserPreviewDTO(
        id = id!!,
        username = username,
        email = email
    )