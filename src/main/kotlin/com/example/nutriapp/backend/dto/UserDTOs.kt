package com.example.nutriapp.backend.dto

data class AuthRequest(
    val email: String,
    val password: String,
    val username: String? = null // only for signup
)

data class AuthResponse(
    val id: Int,
    val username: String,
    val email: String,
    val token: String
)