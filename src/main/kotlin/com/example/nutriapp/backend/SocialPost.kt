package com.example.nutriapp.backend

import com.example.nutriapp.backend.enums.PostVisibility
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "social_post",
    indexes = [Index(name = "idx_user", columnList = "userId")]
)
data class SocialPost(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val userId: Int,
    val dateTime: String,
    val description: String,

    @Enumerated(EnumType.STRING)
    val visibility: PostVisibility
)