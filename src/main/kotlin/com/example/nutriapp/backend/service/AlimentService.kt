package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.AlimentDTO
import com.example.nutriapp.backend.entity.AlimentEntity
import com.example.nutriapp.backend.entity.CompositionAlimentEntity
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.repository.AlimentRepository
import com.example.nutriapp.backend.repository.NutrientRepository
import org.springframework.stereotype.Service

@Service
class AlimentService(
    private val alimentRepo: AlimentRepository,
    private val nutrientRepo: NutrientRepository
) {

    fun getAll(): List<AlimentDTO> =
        alimentRepo.findAll().map { it.toDTO() }

    fun getById(id: Int): AlimentDTO =
        alimentRepo.findById(id)
            .orElseThrow()
            .toDTO()

    fun create(dto: AlimentDTO): AlimentDTO {

        val aliment = AlimentEntity(
            name = dto.name,
            description = dto.description,
            type = dto.type,
            updatedAt = System.currentTimeMillis()
        )

        val saved = alimentRepo.save(aliment)

        val compositions = dto.nutrients.map {
            CompositionAlimentEntity(
                amountPer100g = it.amountPer100g,
                aliment = saved,
                nutrient = nutrientRepo.findById(it.idNutrient).orElseThrow()
            )
        }

        val updated = alimentRepo.save(
            saved.copy(compositions = compositions)
        )

        return updated.toDTO()
    }

    fun update(id: Int, dto: AlimentDTO): AlimentDTO {
        val existing = alimentRepo.findById(id).orElseThrow()

        val compositions = dto.nutrients.map {
            CompositionAlimentEntity(
                amountPer100g = it.amountPer100g,
                aliment = existing,
                nutrient = nutrientRepo.findById(it.idNutrient).orElseThrow()
            )
        }

        val updated = alimentRepo.save(
            existing.copy(
                name = dto.name,
                description = dto.description,
                type = dto.type,
                compositions = compositions,
                updatedAt = System.currentTimeMillis()
            )
        )

        return updated.toDTO()
    }

    fun delete(id: Int) {
        alimentRepo.deleteById(id)
    }
}
