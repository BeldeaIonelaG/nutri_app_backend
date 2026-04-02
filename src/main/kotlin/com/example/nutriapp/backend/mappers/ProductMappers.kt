package com.example.nutriapp.backend.mappers

import com.example.nutriapp.backend.dto.CompositionProductDTO
import com.example.nutriapp.backend.dto.ProductDTO
import com.example.nutriapp.backend.dto.ProductIngredientDTO
import com.example.nutriapp.backend.entity.ProductEntity

fun ProductEntity.toDTO() = ProductDTO(
    id = id,
    name = name,
    description = description,
    type = type,
    nutrients = compositions.map {
        CompositionProductDTO(
            id = it.id,
            idNutrient = it.nutrient.id,
            amountPer100g = it.amountPer100g
        )
    },
    ingredients = ingredients.map {
        ProductIngredientDTO(
            id = it.id,
            idAliment = it.aliment.id,
            quantity = it.quantity,
            measurementUnit = it.measurementUnit
        )
    },
    barcodes = barcodes.map { it.barcode }
)