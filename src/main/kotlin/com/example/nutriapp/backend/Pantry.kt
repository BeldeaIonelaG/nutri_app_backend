package com.example.nutriapp.backend
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "pantry",
    indexes = [Index(name = "idx_owner", columnList = "ownerId")]
)
data class Pantry(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val ownerId: Int,
    val name: String
)