package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.AlarmEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AlarmRepository : JpaRepository<AlarmEntity, Int> {

    fun findByUserId(userId: Int): List<AlarmEntity>

    fun findByEventId(eventId: Int): List<AlarmEntity>
}