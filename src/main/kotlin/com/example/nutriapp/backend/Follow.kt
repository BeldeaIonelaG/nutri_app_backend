package com.example.nutriapp.backend

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "follows",
    indexes = [
        Index(name = "idx_follower", columnList = "followerId"),
        Index(name = "idx_followed", columnList = "followedId")
    ]
)
@IdClass(FollowId::class)
data class Follow(
    @Id val followerId: Int,
    @Id val followedId: Int
)