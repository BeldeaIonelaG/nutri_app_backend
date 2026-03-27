package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.entity.IntakeEntity
import org.springframework.stereotype.Service
import com.example.nutriapp.backend.repository.IntakeRepository

@Service
class IntakeService(private val repo: IntakeRepository) {
    fun getAll() = repo.findAll()
    fun create(intake: IntakeEntity) = repo.save(intake)
}
