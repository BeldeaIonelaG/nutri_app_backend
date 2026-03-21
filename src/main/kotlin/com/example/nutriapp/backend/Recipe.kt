package com.example.nutriapp.backend

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(
    name = "recipes",
    indexes = [
        Index(name = "idx_cookbook", columnList = "idCookbook"),
        Index(name = "idx_prev", columnList = "previousRecipeId")
    ]
)
data class Recipe(
    @Id
    val id: Int,

    val name: String,
    val description: String,
    val instructions: String,
    val idCookbook: Int,
    val idInitialCreator: Int,
    val idCreator: Int,
    val creationDate: LocalDate,
    val servings: Int,
    val difficultyLevel: Int,
    val type: String,
    val previousRecipeId: Int?
)