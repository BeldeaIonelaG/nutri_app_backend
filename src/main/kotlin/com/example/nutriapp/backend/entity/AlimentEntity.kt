package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "aliment")
data class AlimentEntity(
    @Id val id: Int,
    val name: String,
    val description: String,
    val type: String
)
