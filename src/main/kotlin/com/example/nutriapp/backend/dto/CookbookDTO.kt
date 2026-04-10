package com.example.nutriapp.backend.dto

import java.time.LocalDate

data class CookbookDTO(
    val id: Int?,
    val name: String,
    val description: String,
    val idCreator: Int,
    val creationDate: LocalDate?,
    val visibility: String,
    val updatedAt: Long
)