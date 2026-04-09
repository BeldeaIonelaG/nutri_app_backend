package com.example.nutriapp.backend.dto

data class CookbookDTO(
    val id: Int?,
    val name: String,
    val description: String,
    val idCreator: Int,
    val creationDate: Long,
    val visibility: String,
    val updatedAt: Long
)