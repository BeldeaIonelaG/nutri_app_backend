package com.example.nutriapp.backend

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "composition_recipe",
    indexes = [Index(name = "idx_recipe", columnList = "idRecipe")]
)
data class CompositionRecipe(
    @Id
    val id: Int,

    val idRecipe: Int,
    val idNutrient: Int,
    val amountPer100g: Double
)