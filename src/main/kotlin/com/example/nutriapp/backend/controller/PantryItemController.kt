package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.repository.PantryItemRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pantry-items")
class PantryItemController(private val repo: PantryItemRepository) {

    @GetMapping
    fun getAll() = repo.findAll()
}