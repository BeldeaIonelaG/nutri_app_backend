package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "nutrient_intake")
data class NutrientIntakeEntity(
    @Id val id: Int,
    val intakeId: Int,
    val userId: Int,
    val nutrientId: Int,
    val quantity: Double
)

