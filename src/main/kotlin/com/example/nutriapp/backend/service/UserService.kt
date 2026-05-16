package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.UserPreviewDTO
import com.example.nutriapp.backend.mappers.toPreviewDTO
import com.example.nutriapp.backend.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class PasswordService {
    private val encoder = BCryptPasswordEncoder()

    fun hash(password: String) = encoder.encode(password)

    fun verify(password: String, hash: String?) =
        encoder.matches(password, hash)
}

@Service
class UserService(
    private val repo: UserRepository
){

    fun getPreview(
        id:Int
    ): UserPreviewDTO {

        return repo
            .findById(id)
            .orElseThrow()
            .toPreviewDTO()
    }
}