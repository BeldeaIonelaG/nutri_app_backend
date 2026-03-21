package com.example.nutriapp.backend
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(name = "friends")
@IdClass(FriendId::class)
data class Friend(
    @Id val userId1: Int,
    @Id val userId2: Int
)