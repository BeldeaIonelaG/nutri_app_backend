package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.FoodPreferenceDTO
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.FoodPreferenceRepository
import org.springframework.stereotype.Service

@Service
class FoodPreferenceService(
    private val repo: FoodPreferenceRepository
) {

    fun getByUser(userId: Int): List<FoodPreferenceDTO> =
        repo.findByUserId(userId).map { it.toDTO() }

    fun add(dto: FoodPreferenceDTO): FoodPreferenceDTO =
        repo.save(dto.toEntity()).toDTO()

    fun remove(dto: FoodPreferenceDTO) {
        repo.deleteByUserIdAndTargetTypeAndTargetId(
            dto.userId,
            dto.targetType,
            dto.targetId
        )
    }
}