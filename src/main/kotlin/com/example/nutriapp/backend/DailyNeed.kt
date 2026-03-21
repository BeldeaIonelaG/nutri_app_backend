package com.example.nutriapp.backend
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate
@Entity
@Table(
    name = "daily_needs",
    indexes = [Index(name = "idx_nutrient", columnList = "nutrientId")]
)
@IdClass(DailyNeedId::class)
data class DailyNeed(
    @Id val userId: Int,
    @Id val nutrientId: Int,
    val quantity: Double
)