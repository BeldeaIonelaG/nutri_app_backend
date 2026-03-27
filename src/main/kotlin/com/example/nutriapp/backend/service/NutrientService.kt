package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.NutrientDTO
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.NutrientRepository
import org.springframework.stereotype.Service

@Service
class NutrientService(
    private val repository: NutrientRepository
) {

    fun getAll(): List<NutrientDTO> =
        repository.findAll().map { it.toDTO() }

    fun getById(id: Int): NutrientDTO? =
        repository.findById(id).orElse(null)?.toDTO()

    fun create(dto: NutrientDTO): NutrientDTO =
        repository.save(dto.toEntity()).toDTO()

    fun update(id: Int, dto: NutrientDTO): NutrientDTO {
        val existing = repository.findById(id)
            .orElseThrow { RuntimeException("Nutrient not found") }

        val updated = existing.copy(
            description = dto.description,
            type = dto.type,
            measurementUnit = dto.measurementUnit
        )

        return repository.save(updated).toDTO()
    }

    fun delete(id: Int) {
        repository.deleteById(id)
    }
}
