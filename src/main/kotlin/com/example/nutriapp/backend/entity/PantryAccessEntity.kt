package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

import jakarta.persistence.Table

import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import java.io.Serializable

@Embeddable
data class PantryAccessKey(

    @Column(name = "user_id")
    val userId: Int = 0,

    @Column(name = "pantry_id")
    val pantryId: Int = 0

) : Serializable

@Entity
@Table(name = "pantry_access")
data class PantryAccessEntity(


    @EmbeddedId
    val id: PantryAccessKey
)