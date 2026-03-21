package com.example.nutriapp.backend
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(name = "nutrient")
data class Nutrient(
    @Id
    val id: Int,

    val name: String,
    val description: String,
    val type: String,
    val measurementUnit: String
)