package com.example.nutriapp.backend
import jakarta.persistence.*
@Entity
@Table(
    name = "composition_aliments",
    indexes = [
        Index(name = "idx_aliment", columnList = "idAliment"),
        Index(name = "idx_nutrient", columnList = "idNutrient")
    ]
)
data class CompositionAliment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val idAliment: Int,
    val idNutrient: Int,
    val amountPer100g: Double
)