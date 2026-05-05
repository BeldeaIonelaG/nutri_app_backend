package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.io.Serializable

data class NutrientIntakeId(
    val intakeId: Int = 0,
    val nutrientId: Int = 0
) : Serializable

@Entity
@Table(name = "nutrient_intake")
@IdClass(NutrientIntakeId::class)
class NutrientIntakeEntity(


    @Column(name = "intake_id")
    var intakeId: Int,

    @Column(name = "nutrient_id")
    var nutrientId: Int,

    var quantity: Double,

    @ManyToOne
    @JoinColumn(name = "intake_id", insertable = false, updatable = false)
    var intake: IntakeEntity? = null
)