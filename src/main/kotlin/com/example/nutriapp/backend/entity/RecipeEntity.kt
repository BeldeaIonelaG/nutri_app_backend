package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "recipe")
data class RecipeEntity(
    @Id val id: Int,
    val name: String,
    val description: String,
    val instructions: String,
    val idCookbook: Int,
    val idCreator: Int
)

