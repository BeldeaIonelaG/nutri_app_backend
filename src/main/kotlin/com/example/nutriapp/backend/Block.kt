package com.example.nutriapp.backend
import jakarta.persistence.*

@Entity
@Table(name = "blocks")
@IdClass(BlockId::class)
data class Block(
    @Id
    val blockerId: Int,

    @Id
    val blockedId: Int
)