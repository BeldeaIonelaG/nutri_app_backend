package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "pantry_item")
data class PantryItemEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "pantry_id")
    val pantryId: Int,

    val type: String,

    @Column(name = "item_id")
    val itemId: Int?,

    val quantity: Double,

    @Column(name = "measurement_unit")
    val measurementUnit: String,

    @Column(name = "expiration_date")
    val expirationDate: LocalDate?
)