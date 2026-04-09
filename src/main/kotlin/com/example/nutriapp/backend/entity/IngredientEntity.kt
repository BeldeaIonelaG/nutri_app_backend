package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table

@Embeddable
data class IngredientId(

    @Column(name = "target_id")
    val targetId: Int,

    @Column(name = "id_recipe")
    val idRecipe: Int,

    @Column(name = "target_type")
    val targetType: String
)
@Entity
@Table(name = "ingredient")
data class IngredientEntity(

    @EmbeddedId
    val id: IngredientId,

    var quantity: Double?,

    @Column(name = "measurement_unit")
    var measurementUnit: String?,

    @ManyToOne
    @MapsId("idRecipe")
    @JoinColumn(name = "id_recipe")
    val recipe: RecipeEntity
)

