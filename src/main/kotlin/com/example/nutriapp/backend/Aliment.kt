package com.example.nutriapp.backend
import jakarta.persistence.*


@Entity
@Table(name = "aliments")
data class Aliment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val name: String,
    val description: String,
    val type: String
)