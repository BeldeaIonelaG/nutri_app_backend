package com.example.nutriapp.backend.dto

data class SocialPostDTO(
    val id: Int?,
    val dateTime: String,
    val description: String,
    val visibility: String,
    val contents: List<PostContentDTO>
)

data class PostContentDTO(
    val referenceId: Int,
    val type: String
)