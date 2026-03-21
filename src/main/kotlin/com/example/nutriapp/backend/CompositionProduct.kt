package com.example.nutriapp.backend
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "composition_products",
    indexes = [
        Index(name = "idx_product", columnList = "idProduct"),
        Index(name = "idx_nutrient", columnList = "idNutrient")
    ]
)
data class CompositionProduct(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val idProduct: Int,
    val idNutrient: Int,
    val amountPer100g: Double
)