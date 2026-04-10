package com.example.nutriapp.backend.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime
import jakarta.persistence.Column
import java.time.LocalDate

@Entity
@Table(name = "recipes")
class RecipeEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "creation_date")
    var creationDate: LocalDate?,

    var description: String?,

    @Column(name = "difficulty_level")
    var difficultyLevel: Int?,

    @Column(name = "id_cookbook")
    var idCookbook: Int?,

    @Column(name = "id_creator")
    var idCreator: Int?,

    @Column(name = "id_initial_creator")
    var idInitialCreator: Int?,

    var instructions: String?,
    var name: String,

    @Column(name = "previous_recipe_id")
    var previousRecipeId: Int?,

    var servings: Int?,

    @Column(name = "type")
    var typeM: String?,

    @Column(name = "updated_at")
    var updatedAt: Long = System.currentTimeMillis(),

    @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL], orphanRemoval = true)
    val compositions: MutableList<CompositionRecipeEntity> = mutableListOf(),

    @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL], orphanRemoval = true)
    val ingredients: MutableList<IngredientEntity> = mutableListOf()
)
