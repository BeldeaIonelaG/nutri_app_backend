package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.PantryDTO
import com.example.nutriapp.backend.entity.PantryAccessEntity
import com.example.nutriapp.backend.entity.PantryAccessKey
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.PantryAccessRepository
import com.example.nutriapp.backend.repository.PantryItemRepository
import com.example.nutriapp.backend.repository.PantryRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PantryService(
    private val pantryRepo: PantryRepository,
    private val itemRepo: PantryItemRepository,
    private val accessRepo: PantryAccessRepository
) {

    @Transactional
    fun create(dto: PantryDTO): PantryDTO {

        val savedPantry = pantryRepo.save(dto.toEntity())

        dto.items.forEach {

            savedPantry.items.add(
                it.toEntity(savedPantry)
            )
        }
        val access = dto.access.map {
            accessRepo.save(
                PantryAccessEntity(
                    id = PantryAccessKey(
                        userId = it,
                        pantryId = savedPantry.id
                    )
                )
            )
        }

        return savedPantry.toDTO(
            savedPantry.items,
            access
        )
    }

    fun getByUser(userId: Int): List<PantryDTO> {
        val pantries = pantryRepo.findByOwnerId(userId)

        return pantries.map { pantry ->
            val items = itemRepo.findByIdPantryId(pantry.id)
            val access = accessRepo.findByIdPantryId(pantry.id)

            pantry.toDTO(items, access)
        }
    }
}