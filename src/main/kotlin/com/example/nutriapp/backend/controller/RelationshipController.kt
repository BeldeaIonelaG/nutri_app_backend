package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.repository.RelationshipRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/relationships")
class RelationshipController(private val repo: RelationshipRepository) {

    @GetMapping
    fun getAll() = repo.findAll()
}