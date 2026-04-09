package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table

@Embeddable
data class CompositionRecipeId(
    @Column(name = "id_nutrient")
    val idNutrient: Int,

    @Column(name = "id_recipe")
    val idRecipe: Int
)
@Entity
@Table(name = "composition_recipe")
data class CompositionRecipeEntity(

    @EmbeddedId
    val id: CompositionRecipeId,

    @Column(name = "amount_per100g")
    val amountPer100g: Double,

    @ManyToOne
    @MapsId("idRecipe")
    @JoinColumn(name = "id_recipe")
    val recipe: RecipeEntity,

    @ManyToOne
    @JoinColumn(name = "id_nutrient")
    val nutrient: NutrientEntity
)
