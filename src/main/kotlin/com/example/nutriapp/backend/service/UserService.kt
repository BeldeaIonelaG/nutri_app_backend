package com.example.nutriapp.backend.service

import org.springframework.stereotype.Service
import com.example.nutriapp.backend.repository.UserRepository

@Service
class UserService(private val repo: UserRepository) {
    fun getAll() = repo.findAll()
}
