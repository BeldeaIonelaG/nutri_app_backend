package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Table

data class DailyNeedId(
    val userId: Int = 0,
    val nutrientId: Int = 0
)
@Entity
@IdClass(DailyNeedId::class)
@Table(name = "daily_needs")
data class DailyNeedEntity(

    @Id
    @Column(name = "user_id")
    val userId: Int,

    @Id
    @Column(name = "nutrient_id")
    val nutrientId: Int,

    val quantity: Double
)