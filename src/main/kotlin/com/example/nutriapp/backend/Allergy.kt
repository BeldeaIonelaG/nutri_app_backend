package com.example.nutriapp.backend
import jakarta.persistence.*

@Entity
@Table(
    name = "allergy",
    indexes = [Index(name = "idx_aliment", columnList = "alimentId")]
)
@IdClass(AllergyId::class)
data class Allergy(
    @Id
    val userId: Int,

    @Id
    val alimentId: Int
)