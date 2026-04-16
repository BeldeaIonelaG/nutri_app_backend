package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.IntakeDTO
import com.example.nutriapp.backend.entity.IntakeEntity
import com.example.nutriapp.backend.entity.NutrientIntakeEntity
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.repository.IntakeRepository
import com.example.nutriapp.backend.repository.NutrientIntakeRepository
import org.springframework.stereotype.Service

@Service
class IntakeService(
    private val intakeRepo: IntakeRepository,
    private val nutrientRepo: NutrientIntakeRepository
) {

    fun getAll(userId: Int): List<IntakeDTO> =
        intakeRepo.findByUserId(userId).map { it.toDTO() }

    fun create(dto: IntakeDTO, userId: Int): IntakeDTO {

        val intake = IntakeEntity(
            dateTime = dto.dateTime,
            foodId = dto.foodId,
            foodType = dto.foodType,
            measurementUnit = dto.measurementUnit,
            quantity = dto.quantity,
            userId = userId
        )

        val saved = intakeRepo.save(intake)

        dto.nutrients.forEach {
            val nutrient = NutrientIntakeEntity(
                intakeId = saved.id,
                nutrientId = it.nutrientId,
                quantity = it.quantity,
                userId = userId
            )
            nutrientRepo.save(nutrient)
        }

        return intakeRepo.findById(saved.id).get().toDTO()
    }
}