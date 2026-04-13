package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.CookbookDTO
import com.example.nutriapp.backend.entity.CookbookEntity
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.repository.CookbookRepository
import org.springframework.stereotype.Service

@Service
class CookbookService(
    private val repo: CookbookRepository
) {

    fun getAll(): List<CookbookDTO> =
        repo.findAll().map { it.toDTO() }

    fun getById(id: Int): CookbookDTO =
        repo.findById(id).orElseThrow().toDTO()

    fun create(dto: CookbookDTO): CookbookDTO {

        val entity = CookbookEntity(
            name = dto.name,
            description = dto.description,
            idCreator = dto.idCreator,
            creationDate = dto.creationDate,
            visibility = dto.visibility,
            updatedAt = System.currentTimeMillis()
        )

        return repo.save(entity).toDTO()
    }

    fun update(id: Int, dto: CookbookDTO): CookbookDTO {

        val existing = repo.findById(id).orElseThrow()

        existing.name = dto.name
        existing.description = dto.description
        existing.visibility = dto.visibility
        existing.idCreator = dto.idCreator
        existing.creationDate = dto.creationDate

        existing.updatedAt = System.currentTimeMillis()

        return repo.save(existing).toDTO()
    }

    fun delete(id: Int) {
        repo.deleteById(id)
    }

    fun getByUser(userId: Int): List<CookbookEntity> {
        return repo.findByIdCreator(userId)
    }
}