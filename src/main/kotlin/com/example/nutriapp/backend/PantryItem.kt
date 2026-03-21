package com.example.nutriapp.backend

import com.example.nutriapp.backend.enums.PantryItemType
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "pantry_item",
    indexes = [
        Index(name = "idx_pantry", columnList = "pantryId"),
        Index(name = "idx_type", columnList = "type")
    ]
)
data class PantryItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val pantryId: Int,

    @Enumerated(EnumType.STRING)
    val type: PantryItemType,

    val itemId: Int?,
    val quantity: Double,
    val measurementUnit: String,
    val expirationDate: LocalDate?
)