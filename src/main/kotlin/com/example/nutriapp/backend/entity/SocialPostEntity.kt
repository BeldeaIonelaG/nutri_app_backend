package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "social_post")
data class SocialPostEntity(
    @Id val id: Int,
    val userId: Int,
    val description: String,
    val visibility: String,
    val dateTime: LocalDateTime
)

