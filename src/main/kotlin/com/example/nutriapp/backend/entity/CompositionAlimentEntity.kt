package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "composition_aliments")
data class CompositionAlimentEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @ManyToOne
    @JoinColumn(name = "id_aliment")
    val aliment: AlimentEntity,

    @ManyToOne
    @JoinColumn(name = "id_nutrient")
    val nutrient: NutrientEntity,

    @Column(name = "amount_per100g")
    val amountPer100g: Double
)

