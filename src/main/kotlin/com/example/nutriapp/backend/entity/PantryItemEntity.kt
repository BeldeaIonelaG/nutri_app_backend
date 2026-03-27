package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "pantry_item")
data class PantryItemEntity(
    @Id val id: Int,
    val pantryId: Int,
    val type: String,
    val itemId: Int?,
    val quantity: Double,
    val measurementUnit: String
)


