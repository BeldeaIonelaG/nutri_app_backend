package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.EventDTO
import com.example.nutriapp.backend.dto.EventInvitationDTO
import com.example.nutriapp.backend.entity.EventEntity
import com.example.nutriapp.backend.entity.EventInvitationEntity
import java.time.LocalDateTime

fun EventEntity.toDTO(): EventDTO =
    EventDTO(
        id = id,
        beginDateTime = beginDateTime.toString(),
        endDateTime = endDateTime.toString(),
        name = name,
        description = description,
        invitations = invitations.map { it.toDTO() },
        foods = foods.map { it.id.idPost }
    )

fun EventInvitationEntity.toDTO(): EventInvitationDTO =
    EventInvitationDTO(
        personId = id.personId,
        status = status
    )

fun EventDTO.toEntity(userId: Int): EventEntity =
    EventEntity(
        beginDateTime = LocalDateTime.parse(beginDateTime),
        endDateTime = LocalDateTime.parse(endDateTime),
        name = name,
        description = description,
        hostId = userId
    )