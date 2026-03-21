package com.example.nutriapp.backend
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(name = "cookbooks")
data class Cookbook(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val name: String,
    val description: String,
    val idCreator: Int,
    val creationDate: LocalDate,
    val visibility: String
)