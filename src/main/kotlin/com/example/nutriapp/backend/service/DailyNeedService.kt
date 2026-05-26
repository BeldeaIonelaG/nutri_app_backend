package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.DailyNeedDTO
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.DailyNeedRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class DailyNeedService(
    private val repo: DailyNeedRepository
) {

    fun getByUser(userId: Int): List<DailyNeedDTO> =
        repo.findByUserId(userId)
            .map { it.toDTO() }

    /**
     * Replace ALL user daily needs (safe sync)
     */
    @Transactional
    fun replaceAll(userId: Int, needs: List<DailyNeedDTO>) {

        // ❗ enforce user ownership
        val safeNeeds = needs.map {
            it.copy(userId = userId)
        }

        // delete old
        repo.deleteByUserId(userId)

        // insert new
        repo.saveAll(
            safeNeeds.map { it.toEntity() }
        )
    }
}