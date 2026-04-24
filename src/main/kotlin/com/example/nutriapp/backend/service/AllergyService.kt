package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.AllergyDTO
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.AllergyRepository
import org.springframework.stereotype.Service

@Service
class AllergyService(
    private val repo: AllergyRepository
) {

    fun getByUser(userId: Int): List<AllergyDTO> =
        repo.findByUserId(userId).map { it.toDTO() }

    fun add(dto: AllergyDTO): AllergyDTO =
        repo.save(dto.toEntity()).toDTO()

    fun remove(dto: AllergyDTO) {
        repo.deleteByUserIdAndAlimentId(dto.userId, dto.alimentId)
    }
}