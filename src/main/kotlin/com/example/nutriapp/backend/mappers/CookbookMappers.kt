package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.CookbookDTO
import com.example.nutriapp.backend.entity.CookbookEntity

fun CookbookEntity.toDTO() = CookbookDTO(
    id = id,
    name = name,
    description = description,
    idCreator = idCreator,
    creationDate = creationDate,
    visibility = visibility,
    updatedAt = updatedAt
)