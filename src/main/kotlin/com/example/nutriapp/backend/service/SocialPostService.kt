package com.example.nutriapp.backend.service

import org.springframework.stereotype.Service
import com.example.nutriapp.backend.repository.SocialPostRepository

@Service
class SocialPostService(private val repo: SocialPostRepository) {
    fun getAll() = repo.findAll()
}
