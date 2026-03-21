package com.example.nutriapp.backend

import com.example.nutriapp.backend.enums.InvitationStatus
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "event_invitation",
    indexes = [Index(name = "idx_person", columnList = "personId")]
)
@IdClass(EventInvitationId::class)
data class EventInvitation(
    @Id val eventId: Int,
    @Id val personId: Int,

    @Enumerated(EnumType.STRING)
    val status: InvitationStatus
)