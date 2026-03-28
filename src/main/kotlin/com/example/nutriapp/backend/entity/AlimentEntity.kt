package com.example.nutriapp.backend.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "aliments")
data class AlimentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val name: String,

    val description: String,

    val type: String,

    @OneToMany(mappedBy = "aliment", cascade = [CascadeType.ALL], orphanRemoval = true)
    val compositions: List<CompositionAlimentEntity> = emptyList()
)