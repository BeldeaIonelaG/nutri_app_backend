package com.example.nutriapp.backend

import com.example.nutriapp.backend.enums.IngredientTargetType
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "ingredient",
    indexes = [
        Index(name = "idx_recipe", columnList = "idRecipe"),
        Index(name = "idx_target", columnList = "targetType, targetId")
    ]
)
data class Ingredient(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val idRecipe: Int,

    @Enumerated(EnumType.STRING)
    val targetType: IngredientTargetType,

    val targetId: Int,

    val quantity: Double,
    val measurementUnit: String
)