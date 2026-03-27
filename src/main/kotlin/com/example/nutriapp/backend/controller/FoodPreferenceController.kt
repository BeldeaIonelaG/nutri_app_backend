package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.repository.FoodPreferenceRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/preferences")
class FoodPreferenceController(private val repo: FoodPreferenceRepository) {

    @GetMapping
    fun getAll() = repo.findAll()
}