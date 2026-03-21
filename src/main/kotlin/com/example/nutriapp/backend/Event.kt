package com.example.nutriapp.backend

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "event",
    indexes = [
        Index(name = "idx_host", columnList = "hostId"),
        Index(name = "idx_begin", columnList = "beginDateTime"),
        Index(name = "idx_end", columnList = "endDateTime")
    ]
)
data class Event(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val beginDateTime: String,
    val endDateTime: String,
    val name: String,
    val description: String,
    val hostId: Int
)