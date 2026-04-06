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

        if (userRepo.findByEmail(req.email) != null) {
            throw RuntimeException("Email already exists")
        }

        val user = userRepo.save(
            UserEntity(
                username = req.username!!,
                email = req.email,
                passwordHash = passwordService.hash(req.password)
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

        val user = userRepo.findByEmail(req.email)
            ?: throw RuntimeException("User not found")

        if (!passwordService.verify(req.password, user.passwordHash)) {
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