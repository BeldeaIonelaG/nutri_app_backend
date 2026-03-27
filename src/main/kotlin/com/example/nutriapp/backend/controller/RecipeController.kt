package com.example.nutriapp.backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.nutriapp.backend.service.RecipeService

@RestController
@RequestMapping("/recipes")
class RecipeController(private val service: RecipeService) {

    @GetMapping
    fun getAll() = service.getAll()
}