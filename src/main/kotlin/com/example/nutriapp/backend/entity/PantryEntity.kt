package com.example.nutriapp.backend.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.OneToMany

@Entity
@Table(name = "pantry")
data class PantryEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val name: String,

    @Column(name = "owner_id")
    val ownerId: Int,

    @OneToMany(
        mappedBy = "pantry",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    val items: MutableList<PantryItemEntity> = mutableListOf()
)