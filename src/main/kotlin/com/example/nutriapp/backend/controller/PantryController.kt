package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.repository.PantryRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pantries")
class PantryController(private val repo: PantryRepository) {

    @GetMapping
    fun getAll() = repo.findAll()
}