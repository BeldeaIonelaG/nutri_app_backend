package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "event")
data class EventEntity(
    @Id val id: Int,
    val beginDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val name: String,
    val description: String,
    val hostId: Int
)
