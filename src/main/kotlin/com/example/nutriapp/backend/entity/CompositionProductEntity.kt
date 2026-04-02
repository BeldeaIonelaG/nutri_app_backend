package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "composition_products")
class CompositionProductEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    var amountPer100g: Double,

    @ManyToOne
    @JoinColumn(name = "id_product")
    var product: ProductEntity,

    @ManyToOne
    @JoinColumn(name = "id_nutrient")
    var nutrient: NutrientEntity
)