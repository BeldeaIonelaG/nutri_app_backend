package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.DailyNeedEntity
import com.example.nutriapp.backend.entity.DailyNeedId
import org.springframework.data.jpa.repository.JpaRepository

interface DailyNeedRepository :
    JpaRepository<DailyNeedEntity, DailyNeedId> {

    fun findByUserId(userId: Int): List<DailyNeedEntity>

    fun deleteByUserId(userId: Int)
}