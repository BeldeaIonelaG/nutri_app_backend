package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.AllergyDTO
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.AllergyRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AllergyService(
    private val repo: AllergyRepository
) {

    fun getByUser(userId: Int): List<AllergyDTO> =
        repo.findByUserId(userId).map { it.toDTO() }

    fun add(dto: AllergyDTO): AllergyDTO =
        repo.save(dto.toEntity()).toDTO()

    @Transactional
    fun replaceAll(

        userId:Int,

        allergies: List<AllergyDTO>
    ){

        // delete old
        repo.deleteByUserId(userId)

        // insert new
        repo.saveAll(

            allergies.map {

                it.copy(
                    userId = userId
                ).toEntity()
            }
        )
    }
}