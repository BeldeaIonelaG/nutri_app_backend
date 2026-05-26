package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.DailyNeedDTO
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.DailyNeedRepository
import jakarta.transaction.Transactional
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class DailyNeedService(
    private val repo: DailyNeedRepository
) {

    fun getByUser(): List<DailyNeedDTO> {
        val auth = SecurityContextHolder.getContext().authentication

        val userId = (auth?.principal ?: 0) as Int

        return repo.findByUserId(userId).map { it.toDTO() }

    }

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