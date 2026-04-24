package com.example.nutriapp.backend.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "event")
class EventEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "begin_date_time")
    var beginDateTime: LocalDateTime,

    @Column(name = "end_date_time")
    var endDateTime: LocalDateTime,

    var name: String,
    var description: String,

    @Column(name = "host_id")
    var hostId: Int,

    @OneToMany(mappedBy = "event", cascade = [CascadeType.ALL], orphanRemoval = true)
    val invitations: MutableList<EventInvitationEntity> = mutableListOf(),

    @OneToMany(mappedBy = "event", cascade = [CascadeType.ALL], orphanRemoval = true)
    val foods: MutableList<EventFoodEntity> = mutableListOf()
)