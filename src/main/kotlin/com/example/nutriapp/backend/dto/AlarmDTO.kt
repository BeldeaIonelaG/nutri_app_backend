package com.example.nutriapp.backend.dto

data class AlarmDTO(
    val id: Int?,
    val description: String,
    val eventId: Int,
    val userId: Int
)