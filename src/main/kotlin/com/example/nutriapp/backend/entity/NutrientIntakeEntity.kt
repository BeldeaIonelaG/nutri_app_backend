package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table
import java.io.Serializable

@Embeddable
data class NutrientIntakeKey(
    val intakeId: Int = 0,
    val nutrientId: Int = 0
) : Serializable

@Entity
@Table(name = "nutrient_intake")
data class NutrientIntakeEntity(

    @EmbeddedId
    val id: NutrientIntakeKey,

    val quantity: Double,

    @ManyToOne
    @MapsId("intakeId")
    @JoinColumn(name = "intake_id")
    val intake: IntakeEntity
)