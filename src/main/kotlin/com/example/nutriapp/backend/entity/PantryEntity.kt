package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "pantry")
data class PantryEntity(
    @Id val id: Int,
    val ownerId: Int,
    val name: String
)


