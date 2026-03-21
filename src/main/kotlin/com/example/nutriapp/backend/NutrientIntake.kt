package com.example.nutriapp.backend

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "nutrient_intake",
    indexes = [
        Index(name = "idx_user", columnList = "userId"),
        Index(name = "idx_nutrient", columnList = "nutrientId"),
        Index(name = "idx_intake", columnList = "intakeId")
    ]
)
data class NutrientIntake(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val intakeId: Int,
    val userId: Int,
    val nutrientId: Int,
    val quantity: Double
)