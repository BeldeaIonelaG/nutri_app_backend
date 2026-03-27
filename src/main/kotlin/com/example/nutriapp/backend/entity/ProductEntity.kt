package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "product")
data class ProductEntity(
    @Id val id: Int,
    val name: String,
    val description: String,
    val type: String
)
