package com.example.nutriapp.backend.service

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class PasswordService {
    private val encoder = BCryptPasswordEncoder()

    fun hash(password: String) = encoder.encode(password)

    fun verify(password: String, hash: String) =
        encoder.matches(password, hash)
}