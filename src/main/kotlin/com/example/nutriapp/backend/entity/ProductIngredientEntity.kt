package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "product_ingredients")
class ProductIngredientEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    var quantity: Double,
    var measurementUnit: String,

    @ManyToOne
    @JoinColumn(name = "id_product")
    var product: ProductEntity,

    @ManyToOne
    @JoinColumn(name = "id_aliment")
    var aliment: AlimentEntity
)