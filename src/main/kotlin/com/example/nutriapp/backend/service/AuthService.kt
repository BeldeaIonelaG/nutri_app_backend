package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.AuthRequest
import com.example.nutriapp.backend.dto.AuthResponse
import com.example.nutriapp.backend.entity.UserEntity
import com.example.nutriapp.backend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepo: UserRepository,
    private val passwordService: PasswordService,
    private val jwtService: JwtService
) {

    fun signup(req: AuthRequest): AuthResponse {

        val username = req.username ?: throw RuntimeException("Username required")
        val email = req.email ?: throw RuntimeException("Email required")
        val password = req.password ?: throw RuntimeException("Password required")

        if (userRepo.findByEmail(email) != null) {
            throw RuntimeException("Email already exists")
        }

        val user = userRepo.save(
            UserEntity(
                username = username,
                email = email,
                passwordHash = passwordService.hash(password)
            )
        )

        return AuthResponse(
            id = user.id!!,
            username = user.username,
            email = user.email,
            token = jwtService.generateToken(user)
        )
    }

    fun login(req: AuthRequest): AuthResponse {

        val email = req.email ?: throw RuntimeException("Email required")
        val password = req.password ?: throw RuntimeException("Password required")

        val user = userRepo.findByEmail(email)
            ?: throw RuntimeException("User not found")

        if (!passwordService.verify(password, user.passwordHash)) {
            throw RuntimeException("Invalid password")
        }

        return AuthResponse(
            id = user.id!!,
            username = user.username,
            email = user.email,
            token = jwtService.generateToken(user)
        )
    }
}