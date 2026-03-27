package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "post_content")
data class PostContentEntity(
    @Id val id: Int,
    val postId: Int,
    val type: String,
    val referenceId: Int
)

