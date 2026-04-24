package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.AllergyDTO
import com.example.nutriapp.backend.entity.AllergyEntity

fun AllergyEntity.toDTO() =
    AllergyDTO(userId, alimentId)

fun AllergyDTO.toEntity() =
    AllergyEntity(userId, alimentId)