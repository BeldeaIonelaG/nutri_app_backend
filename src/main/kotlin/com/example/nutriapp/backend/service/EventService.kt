package com.example.nutriapp.backend.service

import org.springframework.stereotype.Service
import com.example.nutriapp.backend.repository.EventRepository

@Service
class EventService(private val repo: EventRepository) {
    fun getAll() = repo.findAll()
}
