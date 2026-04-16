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
@Table(name = "intake")
class IntakeEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "date_time")
    var dateTime: String,

    @Column(name = "food_id")
    var foodId: Int,

    @Column(name = "food_type")
    var foodType: String,

    @Column(name = "measurement_unit")
    var measurementUnit: String,

    var quantity: Double,

    @Column(name = "user_id")
    var userId: Int,

    @OneToMany(mappedBy = "intake", cascade = [CascadeType.ALL], orphanRemoval = true)
    val nutrients: MutableList<NutrientIntakeEntity> = mutableListOf()
)