package com.example.nutriapp.backend

import jakarta.persistence.*

@Entity
@Table(
    name = "alarms",
    indexes = [
        Index(name = "idx_user", columnList = "userId"),
        Index(name = "idx_event", columnList = "eventId")
    ]
)
data class Alarm(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val userId: Int,
    val eventId: Int,
    val description: String
)