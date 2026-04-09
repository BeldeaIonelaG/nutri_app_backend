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
            updatedAt = System.currentTimeMillis(),
            compositions = mutableListOf() // ✅ important
        )
// ✅ build compositions and attach to SAME instance
        dto.nutrients.forEach {
            val comp = CompositionAlimentEntity(
                id = null,
                amountPer100g = it.amountPer100g,
                aliment = aliment,
                nutrient = nutrientRepo.findById(it.idNutrient).orElseThrow()
            )
            aliment.compositions.add(comp)
        }
// ✅ single save
        val saved = alimentRepo.save(aliment)
        return saved.toDTO()
    }

    fun update(id: Int, dto: AlimentDTO): AlimentDTO {
        val existing = alimentRepo.findById(id).orElseThrow()
// ✅ update fields directly
        existing.name = dto.name
        existing.description = dto.description
        existing.type = dto.type
        existing.updatedAt = System.currentTimeMillis()
// ✅ clear old compositions
        existing.compositions.clear()
// ✅ add new ones
        dto.nutrients.forEach {
            val comp = CompositionAlimentEntity(
                id = null,
                amountPer100g = it.amountPer100g,
                aliment = existing,
                nutrient = nutrientRepo.findById(it.idNutrient).orElseThrow()
            )
            existing.compositions.add(comp)
        }
        val saved = alimentRepo.save(existing)
        return saved.toDTO()
    }

    fun delete(id: Int) {
        alimentRepo.deleteById(id)
    }
}