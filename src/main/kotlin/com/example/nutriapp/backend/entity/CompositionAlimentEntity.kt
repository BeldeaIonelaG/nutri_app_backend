package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "composition_aliments")
data class CompositionAlimentEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "id_aliment")
    val idAliment: Int,

    @Column(name = "id_nutrient")
    val idNutrient: Int,

    @Column(name = "amount_per_100g")
    val amountPer100g: Double
)

