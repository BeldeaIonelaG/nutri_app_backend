package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "intake")
data class IntakeEntity(
    @Id val id: Int,
    val userId: Int,
    val foodType: String,
    val foodId: Int,
    val quantity: Double,
    val measurementUnit: String,
    val dateTime: LocalDateTime
)
