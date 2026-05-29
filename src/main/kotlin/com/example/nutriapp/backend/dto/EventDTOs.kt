package com.example.nutriapp.backend.dto

data class EventFoodDTO(
    val idFood: Int,
    val type: String
)

data class EventDTO(
    val id: Int?,
    val beginDateTime: String,
    val endDateTime: String,
    val name: String,
    val description: String,
    val invitations: List<EventInvitationDTO>,
    val foods: List<EventFoodDTO>
)

data class EventInvitationDTO(
    val personId: Int,
    val status: String
)