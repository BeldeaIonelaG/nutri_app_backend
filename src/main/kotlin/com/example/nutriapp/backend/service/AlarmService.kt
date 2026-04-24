package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.AlarmDTO
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.AlarmRepository
import org.springframework.stereotype.Service

@Service
class AlarmService(
    private val repo: AlarmRepository
) {

    fun create(dto: AlarmDTO): AlarmDTO =
        repo.save(dto.toEntity()).toDTO()

    fun getByUser(userId: Int): List<AlarmDTO> =
        repo.findByUserId(userId).map { it.toDTO() }

    fun getByEvent(eventId: Int): List<AlarmDTO> =
        repo.findByEventId(eventId).map { it.toDTO() }
}