package com.example.nutriapp.backend.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
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

    var name: String,

    var description: String,

    var type: String,

    @OneToMany(mappedBy = "aliment", cascade = [CascadeType.ALL], orphanRemoval = true)
    val compositions: MutableList<CompositionAlimentEntity> = mutableListOf(),

    @Column(name = "updated_at")
    var updatedAt: Long = System.currentTimeMillis()
)