package com.example.nutriapp.backend

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "event_food",
    indexes = [
        Index(name = "idx_event", columnList = "idEvent"),
        Index(name = "idx_post", columnList = "idPost")
    ]
)
data class EventFood(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val idEvent: Int,
    val idPost: Int
)