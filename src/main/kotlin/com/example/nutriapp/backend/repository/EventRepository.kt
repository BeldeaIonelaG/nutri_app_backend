package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.EventEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository : JpaRepository<EventEntity, Int>

