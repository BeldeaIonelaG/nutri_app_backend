package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.PantryDTO
import com.example.nutriapp.backend.dto.PantryItemDTO
import com.example.nutriapp.backend.entity.PantryAccessEntity
import com.example.nutriapp.backend.entity.PantryEntity
import com.example.nutriapp.backend.entity.PantryItemEntity
import com.example.nutriapp.backend.entity.PantryItemKey
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
        access = access.map { it.id.userId }
    )

fun PantryItemEntity.toDTO(): PantryItemDTO =
    PantryItemDTO(
        type = id.type,
        itemId = id.itemId,
        quantity = quantity,
        expirationDate = id.expirationDate?.toString()
    )

fun PantryDTO.toEntity(): PantryEntity =
    PantryEntity(
        id = id ?: 0,
        name = name,
        ownerId = ownerId
    )

fun PantryItemDTO.toEntity(
    pantry: PantryEntity
): PantryItemEntity =
    PantryItemEntity(

        id = PantryItemKey(
            pantryId = pantry.id,
            itemId = itemId ?: 0,
            type = type,
            expirationDate =
                expirationDate.let {
                    LocalDate.parse(it)
                } ?: LocalDate.now()
        ),

        quantity = quantity,

        pantry = pantry
    )