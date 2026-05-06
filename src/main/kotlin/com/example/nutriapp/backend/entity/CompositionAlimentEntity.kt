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
import java.io.Serializable


@Embeddable
data class CompositionAlimentKey(
    @Column(name = "id_aliment")
    val alimentId: Int = 0,
    @Column(name = "id_nutrient")
    val nutrientId: Int = 0
) : Serializable

@Entity
@Table(name = "composition_aliments")
data class CompositionAlimentEntity(

    @EmbeddedId
    val id : CompositionAlimentKey,

    @Column(name = "amount_per100g")
    val amountPer100g: Double,

    @ManyToOne
    @MapsId("alimentId")
    @JoinColumn(name = "id_aliment")
    val aliment: AlimentEntity,

    @ManyToOne
    @MapsId("nutrientId")
    @JoinColumn(name = "id_nutrient")
    val nutrient: NutrientEntity
)
