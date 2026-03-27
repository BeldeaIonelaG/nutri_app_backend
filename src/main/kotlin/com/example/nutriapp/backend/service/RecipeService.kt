package com.example.nutriapp.backend.service

import org.springframework.stereotype.Service
import com.example.nutriapp.backend.repository.RecipeRepository

@Service
class RecipeService(private val repo: RecipeRepository) {
    fun getAll() = repo.findAll()
}
