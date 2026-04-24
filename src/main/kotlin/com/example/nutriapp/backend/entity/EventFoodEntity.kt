package com.example.nutriapp.backend.entity

import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table

@Embeddable
data class EventFoodId(
    val idEvent: Int = 0,
    val idPost: Int = 0
)

@Entity
@Table(name = "event_food")
class EventFoodEntity(

    @EmbeddedId
    val id: EventFoodId,

    @ManyToOne
    @MapsId("idEvent")
    @JoinColumn(name = "id_event")
    var event: EventEntity
)