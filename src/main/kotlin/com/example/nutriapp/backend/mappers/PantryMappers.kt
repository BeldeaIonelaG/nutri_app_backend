package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.PantryDTO
import com.example.nutriapp.backend.dto.PantryItemDTO
import com.example.nutriapp.backend.entity.PantryAccessEntity
import com.example.nutriapp.backend.entity.PantryEntity
import com.example.nutriapp.backend.entity.PantryItemEntity
import java.time.LocalDate

fun PantryEntity.toDTO(
    items: List<PantryItemEntity>,
    access: List<PantryAccessEntity>
): PantryDTO =
    PantryDTO(
        id = id,
        name = name,
        ownerId = ownerId,
        items = items.map { it.toDTO() },
        access = access.map { it.userId }
    )

fun PantryItemEntity.toDTO(): PantryItemDTO =
    PantryItemDTO(
        id = id,
        type = type,
        itemId = itemId,
        quantity = quantity,
        measurementUnit = measurementUnit,
        expirationDate = expirationDate?.toString()
    )

fun PantryDTO.toEntity(): PantryEntity =
    PantryEntity(
        id = id ?: 0,
        name = name,
        ownerId = ownerId
    )

fun PantryItemDTO.toEntity(pantryId: Int): PantryItemEntity =
    PantryItemEntity(
        id = id ?: 0,
        pantryId = pantryId,
        type = type,
        itemId = itemId,
        quantity = quantity,
        measurementUnit = measurementUnit,
        expirationDate = expirationDate?.let { LocalDate.parse(it) }
    )