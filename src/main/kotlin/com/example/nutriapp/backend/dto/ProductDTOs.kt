package com.example.nutriapp.backend.dto

data class ProductDTO(
    val id: Int?,
    val name: String,
    val description: String,
    val type: String,
    val nutrients: List<CompositionProductDTO>,
    val ingredients: List<ProductIngredientDTO>,
    val barcodes: List<String>
)

data class CompositionProductDTO(
    val id: Int?,
    val idNutrient: Int,
    val amountPer100g: Double
)

data class ProductIngredientDTO(
    val id: Int?,
    val idAliment: Int,
    val quantity: Double,
    val measurementUnit: String
)