package com.example.nutriapp.backend

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "product_ingredients",
    indexes = [
        Index(name = "idx_product", columnList = "idProduct"),
        Index(name = "idx_aliment", columnList = "idAliment")
    ]
)
data class ProductIngredient(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val idProduct: Int,
    val idAliment: Int,
    val quantity: Double,
    val measurementUnit: String
)