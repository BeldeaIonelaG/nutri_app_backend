package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.PantryDTO
import com.example.nutriapp.backend.entity.PantryAccessEntity
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

        val items = dto.items.map {
            itemRepo.save(it.toEntity(savedPantry.id))
        }

        val access = dto.access.map {
            accessRepo.save(
                PantryAccessEntity(
                    userId = it,
                    pantryId = savedPantry.id
                )
            )
        }

        return savedPantry.toDTO(items, access)
    }

    fun getByUser(userId: Int): List<PantryDTO> {
        val pantries = pantryRepo.findByOwnerId(userId)

        return pantries.map { pantry ->
            val items = itemRepo.findByPantryId(pantry.id)
            val access = accessRepo.findByPantryId(pantry.id)

            pantry.toDTO(items, access)
        }
    }
}