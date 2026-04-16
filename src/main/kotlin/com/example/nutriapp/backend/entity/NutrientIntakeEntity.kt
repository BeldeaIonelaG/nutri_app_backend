package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "nutrient_intake")
class NutrientIntakeEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "intake_id")
    var intakeId: Int,

    @Column(name = "nutrient_id")
    var nutrientId: Int,

    var quantity: Double,

    @Column(name = "user_id")
    var userId: Int,

    @ManyToOne
    @JoinColumn(name = "intake_id", insertable = false, updatable = false)
    var intake: IntakeEntity? = null
)