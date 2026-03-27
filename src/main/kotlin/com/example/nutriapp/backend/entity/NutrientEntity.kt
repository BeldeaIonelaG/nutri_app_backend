package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "nutrient")
data class NutrientEntity(
    @Id val id: Int,
    val name: String,
    val description: String,
    val type: String,
    @Column(name = "measurement_unit")
    val measurementUnit: String
)
