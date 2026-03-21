package com.example.nutriapp.backend

import com.example.nutriapp.backend.enums.FoodType
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "intake",
    indexes = [
        Index(name = "idx_user", columnList = "userId"),
        Index(name = "idx_food", columnList = "foodId"),
        Index(name = "idx_date", columnList = "dateTime")
    ]
)
data class Intake(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val userId: Int,

    @Enumerated(EnumType.STRING)
    val foodType: FoodType,

    val foodId: Int,

    val quantity: Double,
    val measurementUnit: String,
    val dateTime: String
)