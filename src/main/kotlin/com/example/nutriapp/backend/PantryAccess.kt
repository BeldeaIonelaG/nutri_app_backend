package com.example.nutriapp.backend

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "pantry_access",
    indexes = [
        Index(name = "idx_user", columnList = "userId"),
        Index(name = "idx_pantry", columnList = "pantryId")
    ]
)
data class PantryAccess(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val userId: Int,
    val pantryId: Int
)