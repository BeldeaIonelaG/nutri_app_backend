package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table
import java.io.Serializable
import java.time.LocalDate

@Embeddable
data class PantryItemKey(

    @Column(name = "pantry_id")
    val pantryId: Int = 0,

    @Column(name = "item_id")
    val itemId: Int = 0,

    @Column(name = "type")
    val type: String = "",

    @Column(name = "expiration_date")
    val expirationDate: LocalDate = LocalDate.now()

) : Serializable

@Entity
@Table(name = "pantry_item")
data class PantryItemEntity(

    @EmbeddedId
    val id: PantryItemKey,

    val quantity: Double,

    @ManyToOne
    @MapsId("pantryId")
    @JoinColumn(name = "pantry_id")
    val pantry: PantryEntity
)