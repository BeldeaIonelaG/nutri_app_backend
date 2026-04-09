package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "cookbooks")
data class CookbookEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "creation_date")
    var creationDate: Long,

    var description: String,

    @Column(name = "id_creator")
    var idCreator: Int,

    var name: String,

    var visibility: String,

    @Column(name = "updated_at")
    var updatedAt: Long
)