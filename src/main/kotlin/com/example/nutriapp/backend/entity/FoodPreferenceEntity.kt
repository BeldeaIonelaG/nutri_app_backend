package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "food_preference")
data class FoodPreferenceEntity(
    @Id val id: Int,
    val userId: Int,
    val type: String,
    val targetType: String,
    val targetId: Int
)


