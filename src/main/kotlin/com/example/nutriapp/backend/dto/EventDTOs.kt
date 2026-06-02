package com.example.nutriapp.backend.dto

data class EventFoodDTO(
    val idFood: Int,
    val type: String,
    val quantity: Double?
)

data class EventDTO(
    val id: Int?,
    val beginDateTime: String,
    val endDateTime: String,
    val name: String,
    val description: String,
    val invitations: List<EventInvitationDTO>,
    val foods: List<EventFoodDTO>,
    val hostId: Int,
    val type: String
)

data class EventInvitationDTO(
    val personId: Int,
    val status: String
)