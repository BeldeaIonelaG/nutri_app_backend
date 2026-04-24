package com.example.nutriapp.backend.dto

data class EventDTO(
    val id: Int?,
    val beginDateTime: String,
    val endDateTime: String,
    val name: String,
    val description: String,
    val invitations: List<EventInvitationDTO>,
    val foods: List<Int> // postIds
)

data class EventInvitationDTO(
    val personId: Int,
    val status: String
)