package com.example.nutriapp.backend

import java.io.Serializable

data class EventInvitationId(
    val eventId: Int = 0,
    val personId: Int = 0
) : Serializable