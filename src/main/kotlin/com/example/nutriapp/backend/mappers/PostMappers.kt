package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.PostContentDTO
import com.example.nutriapp.backend.dto.SocialPostDTO
import com.example.nutriapp.backend.entity.PostContentEntity
import com.example.nutriapp.backend.entity.SocialPostEntity
import java.time.LocalDateTime

fun SocialPostEntity.toDTO(): SocialPostDTO =
    SocialPostDTO(
        id = id,
        dateTime = dateTime.toString(),
        description = description,
        visibility = visibility,
        contents = contents.map { it.toDTO() },
        userId = userId
    )

fun PostContentEntity.toDTO(): PostContentDTO =
    PostContentDTO(
        referenceId = id.referenceId,
        type = id.type
    )

fun SocialPostDTO.toEntity(userId: Int): SocialPostEntity =
    SocialPostEntity(
        dateTime = LocalDateTime.parse(dateTime),
        description = description,
        visibility = visibility,
        userId = userId
    )