package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.IntakeEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface IntakeRepository : JpaRepository<IntakeEntity, Int> {
    fun findByUserId(userId: Int): List<IntakeEntity>

    fun findByUserIdAndDateTimeAfter( userId:Int, dateTime: LocalDateTime
    ): List<IntakeEntity>
}

