package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "food_preference")
data class FoodPreferenceEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "user_id")
    val userId: Int,

    val type: String,

    @Column(name = "target_type")
    val targetType: String,

    @Column(name = "target_id")
    val targetId: Int
)